<div><h1>UNIVERSIDADE FEDERAL DO RIO GRANDE DO NORTE</h1>
<h2>DISCENTES</h2></div>
<p>AILTON XAVIER</br>
ÁLEFE LEMUEL</p>
<h3>DOCENTE</h3>
ALESSANDRA MENDES PACHECO</br>

## Banco de dados</br>
### Postgresql</br>login = postgres</br>senha = 123<br>banco = BDSolo

<p>ESTRUTURA LÓGICA DO BANCO</p>
CREATE TABLE IF NOT EXISTS Cliente (
pk_cpf TEXT PRIMARY KEY,
nome TEXT,
login TEXT,
senha TEXT,
ativo BOOLEAN NOT NULL DEFAULT(TRUE)
);

CREATE TABLE IF NOT EXISTS Contato(
pk_fk_cpf TEXT PRIMARY KEY,
email TEXT,
celular TEXT,
telFixo TEXT,
telComercial TEXT,
FOREIGN KEY(pk_fk_cpf) REFERENCES Cliente(pk_cpf)
);

CREATE TABLE IF NOT EXISTS Endereco (
pk_fk_cpf TEXT PRIMARY KEY NOT NULL,
estado TEXT,
cidade TEXT,
bairro TEXT,
rua TEXT,
numero TEXT,
FOREIGN KEY(pk_fk_cpf) REFERENCES Cliente(pk_cpf)
);

CREATE TABLE IF NOT EXISTS Aluguel (
id SERIAL PRIMARY KEY,
data TEXT,
dataDaReserva TEXT,
hora TEXT,
horaDaReserva TEXT,
qtdHoras NUMERIC,
valorTotal NUMERIC,
fk_cpf text,
FOREIGN KEY(fk_cpf) REFERENCES Cliente(pk_cpf)
);