# 🛒 Mercadinho - API REST em Java + Frontend React

Projeto full stack de um mini e-commerce (“Mercadinho”), desenvolvido com foco principal no **Back-end em Java utilizando Spring Boot**.

A aplicação permite autenticação de usuários, listagem de produtos, carrinho de compras e fluxo de pagamento simulado no front-end.

---

## 🎯 Objetivo do Projeto

O foco principal deste projeto foi:

- Construção de uma **API REST estruturada**
- Implementação de **Spring Security**
- Integração com banco de dados utilizando **JPA/Hibernate**
- Organização profissional de camadas (Controller, Service, Repository, Entity)
- Integração com frontend React

---

## 🧰 Tecnologias Utilizadas

### 🔹 Back-end (Principal foco)

- Java 17+
- Spring Boot
- Spring Web
- Spring Security (HTTP Basic)
- Spring Data JPA (Hibernate)
- Banco H2 (em memória)
- Maven

### 🔹 Front-end

- React (Vite)
- React Router
- CSS puro

---

## 🏗️ Arquitetura Back-end

O back-end segue arquitetura em camadas:




**controller → service → repository → entity**

- **Controller** → exposição da API REST
- **Service** → regras de negócio
- **Repository** → acesso ao banco de dados
- **Entity** → mapeamento das tabelas com JPA

---

## 🔐 Segurança

A aplicação utiliza **Spring Security com HTTP Basic** para proteger rotas específicas.

Endpoints protegidos exigem autenticação válida.

---

## 📦 Funcionalidades

### Back-end
- Cadastro de usuário
- Autenticação
- Listagem de produtos
- Seed inicial via `data.sql`
- Persistência com JPA/Hibernate

### Front-end
- Tela de Login
- Tela de Cadastro
- Listagem de Produtos
- Carrinho de Compras
- Página de Pagamento (simulado)
- Página de Sucesso

---

## 🚀 Como executar o projeto

### 1️⃣ Back-end

```bash
cd mercadinho
./mvnw spring-boot:run

Servidor disponivel

http://localhost:8080
```
## Front End

```bash
cd mercadinho-front
npm install
npm run dev

http://localhost:5173

```

📌 Endpoints principais

GET  /produtos
POST /auth/register
GET  /auth/me

