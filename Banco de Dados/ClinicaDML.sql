1 -- DML (Data Manipulation Language)
2 -- INSERT (Cadastrar)
3 -- UPDATE (Atualizar)
4 -- DELETE (Apaga)
5 -- OPCIONAL 
SET search_patch TO clinica;

-- INSERT <SCHEMA>.<TABELA> VALUES 
INSERT INTO clinica.medico (nome, especialidade, crm) VALUES 
('Vinicio', 'Ortopedia', '123456'),
('William', 'Clinico Geral', '102293')


-- DQL (Data Query Language) - Linguagem de Consulta de Dados
-- SELECT 
-- SELECT <QUAIS_COLUNAS> FROM <SCHEMA>.<TABELA>
SELECT * FROM clinica.medico;


 - - - - - - - - - - - - - - - - - - 

INSERT INTO clinica.paciente (nome, idade, data_nascimento) VALUES 
('Fulano', 23, '2022-07-20')

SELECT * FROM clinica.paciente;


- - - - - - - - - - - - - - - - - 

INSERT INTO clinica.clinica(nome, descricao, endereco) VALUES 
('clinica Sao Caetano', ' A clinica do ABC', 'Rua Niteroi')

SELECT * FROM clinica.clinica;

- - - - - - - - - - - - - - - - 

INSERT INTO clinica.consulta (data, valor, id_medico, id_clinica, id_paciente) VALUES
('2025-08-28 09:30:00-03', 350.50, 1, 1, 1  )

SELECT * FROM clinica.consulta;


 - - - - - - - - - - - - - - - - - - 
-- UPDATE
UPDATE clinica.consulta
SET valor = 250.50
WHERE id_consulta = 1;

SELECT * FROM clinica.consulta;


WHERE E = A QUEM 


-- DELETE
DELETE FROM clinica.medico;
WHERE id_medico = 1; 

