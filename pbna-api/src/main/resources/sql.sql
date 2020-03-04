/** Agência **/
CREATE TABLE agencia(
	id bigserial NOT NULL UNIQUE,
	nome varchar(300) NOT NULL,
	apelido varchar(100),
	endereco varchar(300),
	CONSTRAINT PK_agencia PRIMARY KEY (id)
);

/** Cliente **/
CREATE TABLE cliente(
	id bigserial NOT NULL UNIQUE,
	nome varchar(300) NOT NULL,
	cpf varchar(20) NOT NULL,
	endereco varchar(300),
	telefone varchar(20),
	id_agencia bigserial NOT NULL,
	CONSTRAINT PK_cliente PRIMARY KEY (id),
    CONSTRAINT FK_cliente_agencia FOREIGN KEY (id_agencia) REFERENCES agencia(id)
);

/** Conta **/
CREATE TABLE conta(
	id bigserial NOT NULL UNIQUE,
	tipo_conta bigint NOT NULL,
	valor decimal(300, 2),
	id_cliente bigserial NOT NULL,
	CONSTRAINT PK_conta PRIMARY KEY (id, tipo_conta),
	CONSTRAINT FK_conta_cliente FOREIGN KEY (id_cliente) REFERENCES cliente(id)
);


/** Operação **/
CREATE TABLE operacao(
	id bigserial NOT NULL UNIQUE,
	valor decimal(300, 2),
	data timestamptz,
	saldo_conta decimal(300, 2),
	id_conta bigserial NOT NULL,
	tipo_conta bigint NOT NULL,
	tipo_operacao bigint NOT NULL,
	tipo_transacao bigint NOT NULL,
	CONSTRAINT PK_operacao PRIMARY KEY (id),
    CONSTRAINT FK_operacao_conta FOREIGN KEY (id_conta, tipo_conta) REFERENCES conta(id, tipo_conta)
);
