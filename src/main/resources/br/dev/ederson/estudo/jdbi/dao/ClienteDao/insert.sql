INSERT INTO cliente (id, nome, email, telefone, data_nascimento, ativo)
VALUES (:id, :nome, :email, :telefone, :dataNascimento, :ativo)
RETURNING id;