package project.budget.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import project.budget.dtos.CompteBancaireRequestDto;
import project.budget.dtos.CompteBancaireResponseDto;
import project.budget.mappers.CompteBancaireMapper;
import project.budget.models.bancaire.CompteBancaire;
import project.budget.services.CompteBancaireService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static project.budget.utils.CompteBancaireUtils.*;
import static project.budget.utils.ResourceUtils.getContent;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CompteBancaireController.class)
class CompteBancaireControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CompteBancaireService service;

    @MockBean
    private CompteBancaireMapper mapper;

    @Value("classpath:comptes/response_single_ok.json")
    private Resource responseOk;

    @Value("classpath:comptes/response_liste_ok.json")
    private Resource responseListOk;

    @Value("classpath:comptes/request_creation_ok.json")
    private Resource requestCreationOk;

    @Captor
    private ArgumentCaptor<UUID> uuidCaptor;

    @Captor
    private ArgumentCaptor<CompteBancaireRequestDto> requestDtoCaptor;

    @Test
    void create_ok() throws Exception {
        CompteBancaireRequestDto requestDto = getBasicRequestDto();
        when(mapper.toEntity(any())).thenReturn(Mockito.mock(CompteBancaire.class));
        when(service.create(any())).thenReturn(Mockito.mock(CompteBancaire.class));
        when(mapper.toDto(any())).thenReturn(getBasicResponseDto());

        mockMvc.perform(post("/comptes/")
                .content(getContent(requestCreationOk))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().json(getContent(responseOk)));

        verify(mapper).toEntity(requestDtoCaptor.capture());
        CompteBancaireRequestDto actual = requestDtoCaptor.getValue();
        assertThat(actual).isEqualTo(requestDto);
    }

    @Test
    void get_ok() throws Exception {
        UUID id = UUID.randomUUID();
        CompteBancaireResponseDto responseDto = getBasicResponseDto();
        when(service.get(any())).thenReturn(Mockito.mock(CompteBancaire.class));
        when(mapper.toDto(any())).thenReturn(responseDto);

        mockMvc.perform(get("/comptes/{id}", id))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().json(getContent(responseOk)));

        verify(service).get(uuidCaptor.capture());
        UUID actual = uuidCaptor.getValue();
        assertThat(actual).isEqualTo(id);
    }

    @Test
    void delete_ok() throws Exception {
        UUID id = UUID.randomUUID();
        doNothing().when(service).delete(any());

        mockMvc.perform(delete("/comptes/{id}", id))
                .andExpect(status().is2xxSuccessful());

        verify(service).delete(uuidCaptor.capture());
        UUID compteId = uuidCaptor.getValue();
        assertThat(compteId).isEqualTo(id);
    }

    @Test
    void getAll_ok() throws Exception {
        List<CompteBancaireResponseDto> responseDtos = getResponseDtoList();
        when(service.getAll()).thenReturn(new ArrayList<>());
        when(mapper.toDtos(anyList())).thenReturn(responseDtos);

        mockMvc.perform(get("/comptes/"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().json(getContent(responseListOk)));
    }
}
