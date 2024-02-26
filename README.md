# Finanças Pro

API do projeto Finanças Pro - Controle de Despesas Pessoais

## Requisitos

- [] CRUD de Categorias
- [] CRUD de Movimentações
- [] CRUD de Usuário
- [] Autenticação
- [] Dashboard

## Documentação

### Endpoints

- [Listar Categoria](#listar-categorias)
- [Cadastrar Categoria](#cadastrar-categoria) 
- [Detalhes da Categoria](#detalhes-da-categoria)
- [Apagar Categoria](#apagar-categoria)
- [Atualizar Categoria](#atualizar-categoria)


### Listar Categorias

`GET` / Categoria

Retorna uma Array com todas as categorias cadastradas

### Exemplo de Respostas 

```js
[
    {
        "id": 1,
        "nome": "Alimentação",
        "icone": "fast-food",
    },
    {
        "id": 2,
        "nome": "Educação",
        "icone": "book",
    },
]

```

#### Código de status

| código | descrição 
|--------|-----------
| `200`  | Categorias retornadas com sucesso.
| `401`  | Não autorizado. Você precisa estar logado.

--------

### Cadastrar Categoria 

`POST` / categoria

Cadastrar uma nova vategoria para um usuario logado com os dados enviados com o corpo da requisição.

#### Corpo da requisição

| campo    | tipo     | obrigatório | descrição
|----------|----------|:-------------:|-----------
| nome| string | ✅ |um nome curto para a categoria 
| icone   | string | ❌ |O nome do icone conforme Material Icons


```js
{
    "nome": "Alimentação",
    "icone": "fast-food",
}

```

### Exemplo de Respostas 

```js
[
    {
        "id": 1,
        "nome": "Alimentação",
        "icone": "fast-food",
    },
    {
        "id": 2,
        "nome": "Educação",
        "icone": "book",
    },
]

```

#### Código de status

| código | descrição 
|--------|-----------
| `201`  | Categorias cadastrada com sucesso.
| `400`  |  Erro na requisição. Verifique os campos enviados e tente novamente.
| `401`  | Não autorizado. Você precisa estar logado.

--------


### Detalhes da Categoria
`GET`/categoria/`{id}`

Retorna as informações detalhadas de uma categoria específica pelo seu ID informado no parametro path.

### Exemplo de Respostas 

```js
// Requisição para /categoria/1
    {
        "id": 1,
        "nome": "Alimentação",
        "icone": "fast-food",
    },

```

#### Código de status

| código | descrição 
|--------|-----------
| `200`  | Dados da Categoria retornados  com sucesso.
| `401`  | Não autorizado. Você precisa estar logado.
| `404`  | A Categoria não foi encontrada. Certifique-se se o id é válido.

--------    

### Apagar Categoria 

`DELETE` /categoria/`{id}`

Apaga a categoria  referenciada pelo ID fornecido no parâmetro do path.

#### Código de status

| código | descrição 
|--------|-----------
| `204`  | Categoria  apagada com sucesso.
| `401`  | Não autorizado. Você precisa estar logado.
| `404`  | A Categoria não foi encontrada. Certifique-se se o id é válido.

-------- 

### Atualizar Categoria

`PUT` /categoria/`{id}`

Atualiza a Categoria referenciada pelo ID fornecido no path, utilizando os novos dados enviados pela requisição

#### Corpo da requisição

| campo    | tipo     | obrigatório | descrição
|----------|----------|:-------------:|-----------
| nome| string | ✅ |um nome curto para a categoria 
| icone   | string | ✅ |O nome do icone conforme Material Icons

```js
{
    "nome": "Alimentação",
    "icone": "fast-food",
}

```

```js
    {
        "id": 1,
        "nome": "Alimentação",
        "icone": "fast-food",
    },

```

#### Código de status

| código | descrição 
|--------|-----------
| `200`  | Categoria atualizada com sucesso 
| `400`  | Erro na requisição. Verifique os campos enviados e tente novamente.
| `404`  | A Categoria não foi encontrada. Certifique-se se o id é válido.








