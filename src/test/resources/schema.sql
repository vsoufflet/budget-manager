drop table if exists comptes_bancaires;

create table comptes_bancaires(
    id uuid not null constraint comptes_bancaires_pkey primary key,
    nom varchar not null,
    solde bigint  not null,
    date_ouverture date not null,
    date_cloture date,
    taux_interets real not null
);