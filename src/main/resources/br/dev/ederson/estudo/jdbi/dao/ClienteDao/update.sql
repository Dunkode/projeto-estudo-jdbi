UPDATE cliente
SET
    nome = :nome,
    email = :email,
    telefone = :telefone,
    data_nascimento = :dataNascimento,
    ativo = :ativo
WHERE
    id = :id;