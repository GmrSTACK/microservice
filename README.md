# Projeto Microservices com Spring Boot e Spring Cloud

Este repositório contém uma implementação de referência para uma arquitetura de microsserviços utilizando o ecossistema Spring (Spring Boot e Spring Cloud).

## 🚀 Tecnologias Utilizadas

-   **Java 17**
-   **Spring Boot 3.2.0**
-   **Spring Cloud 2023.0.0**
-   **Netflix Eureka** (Service Discovery)
-   **Spring Cloud Gateway** (API Gateway)
-   **OpenFeign** (Comunicação entre microsserviços)
-   **H2 Database** (Banco de dados em memória)
-   **Gradle** (Gerenciador de dependências e build)
-   **Lombok**

## 🏗️ Arquitetura do Projeto

O projeto é composto pelos seguintes módulos:

| Serviço | Porta | Descrição |
| :--- | :--- | :--- |
| **discovery-server** | `8761` | Servidor Eureka para registro e descoberta de serviços. |
| **api-gateway** | `8700` | Gateway de entrada. Redireciona requisições para os microsserviços competentes. |
| **product-service** | `8100` | Gerencia o catálogo de produtos. Persistência em memória (H2). |
| **order-service** | `8200` | Simula a criação de pedidos e comunica-se com o `product-service`. |

### 🛣️ Rotas do Gateway

O `api-gateway` está configurado para rotear as requisições da seguinte forma:

-   `http://localhost:8700/produtos/**` ➡️ **product-service**
-   `http://localhost:8700/pedidos/**` ➡️ **order-service**

---

## ⚙️ Pré-requisitos

-   JDK 17 instalado.
-   Variável de ambiente `JAVA_HOME` configurada.

## ▶️ Como Executar

A ordem de inicialização é importante para que os serviços se registrem corretamente no Eureka.

1.  **Discovery Server (Eureka)**
    ```bash
    ./gradlew :discovery-server:bootRun
    ```
    *Aguarde iniciar e acesse http://localhost:8761 para ver o dashboard.*

2.  **Product Service**
    ```bash
    ./gradlew :product-service:bootRun
    ```

3.  **Order Service**
    ```bash
    ./gradlew :order-service:bootRun
    ```

4.  **API Gateway**
    ```bash
    ./gradlew :api-gateway:bootRun
    ```

> *Nota: Em terminais Windows (PowerShell/CMD), utilize `gradlew` (sem o `./`).*

---

## 🧪 Como Testar

Após iniciar todos os serviços, você pode utilizar o Postman, Insomnia ou cURL.

### 1. Criar um Produto (Product Service via Gateway)

**POST** `http://localhost:8700/produtos`

Body (JSON):
```json
{
  "name": "Notebook Gamer",
  "price": 5000.00
}
```

### 2. Listar Produtos

**GET** `http://localhost:8700/produtos`

### 3. Criar um Pedido (Order Service via Gateway)

O serviço de pedidos simula uma chamada ao serviço de produtos para criar um pedido.

**POST** `http://localhost:8700/pedidos`

Body (JSON):
```json
{
  "productIds": [1, 2]
}
```

---

## 📂 Estrutura de Diretórios

```
microservice/
├── api-gateway/       # Configuração de rotas e segurança
├── discovery-server/  # Servidor Eureka
├── order-service/     # Regras de pedidos + Feign Client
├── product-service/   # CRUD de produtos + H2 Database
├── build.gradle       # Configuração raiz (plugins comuns)
└── settings.gradle    # Definição dos módulos
```
