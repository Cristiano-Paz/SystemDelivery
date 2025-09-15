
# 📦 SystemDelivery

##  Sobre o Projeto
O **SystemDelivery** é uma solução de  **backend** robusta, desenvolvida em **Java 21** com **Spring Boot**, focada na gestão eficiente de entregas. O objetivo principal do projeto é oferecer um sistema completo para otimizar e monitorar o processo logistico de ponta a ponta.

Funcionalidades Principais:
-  **Gerenciamento de Entregas** Crie, atualize e gerencie entregas com facilidade. O sistema calcula automaticamente os custos e acompanha o status de cada pedido, além de permitir a associação de múltiplos itens a uma única entrega.
-  **Controle de Couriers** Mantenha um registro detalhado dos entregadores. É possível visualizar suas entregas atuais, o histórico de pedidos finalizados e as tarefas pendentes, facilitando a atribuição e o acompanhamento das rotas.
-  **Fluxo Completo da Entrega** O sistema proporciona uma visão clara de todo o ciclo de vida da entrega, garantindo que cada etapa, do cadastro à finalização, seja rastreada e controlada com precisão. desde o cadastro até a finalização.

---
- **Tecnologias e Arquitetura**

  A modelagem do domínio seguiu a metodologia **Domain-Driven Design (DDD)** para garantir um código limpo, escalável e fácil de manter a longo prazo. Essa abordagem permitiu a criação de um modelo de domínio que reflete fielmente as regras de negócio. Os conceitos de DDD aplicados incluem:
- **Aggregate Roots** Usados para agrupar entidades e objetos de valor, garantindo a consistência das transações e centralizando as regras de negócio.
- **Entity** Objetos com uma identidade única e um ciclo de vida específico no domínio.
- **Value Objects** Objetos que representam valores imutáveis e não têm uma identidade própria, como um endereço ou uma medida de peso.
- **Domain Events** Eventos que sinalizam que algo importante aconteceu no domínio, facilitando a comunicação desacoplada entre diferentes componentes da aplicação.

---

## 📂 Estrutura do Domínio

### 🔹 SystemDelivery (Aggregate Root)
- SystemDelivery UML

### 🔹 Courier (Aggregate Root)
- Courier UML

### 🔹 Outros Componentes
- DeliveryStatus, ContactPoint e Item

---

## 🛠 Tecnologias Utilizadas
-  **Java 21**
-  **Spring Boot**
-  **Spring Data JPA / Hibernate**
-  **JUnit & Mockito** (testes unitários e de integração)
-  **Postman** (coleção de testes de API)
-  **Docker & Docker Compose**
-  **PostgreSQL**
-  **Lombok**
-  **Flyway**

---

##  Como Executar o Projeto

### Pré-requisitos
- [Java 21+](https://jdk.java.net/21/)
- [Maven 3.9+](https://maven.apache.org/)
- [Docker](https://www.docker.com/)

### Passos
1. Clone este repositório:
   ```bash
   git clone https://github.com/seu-usuario/system-delivery.git
   cd system-delivery
   ```

2. Suba o ambiente com Docker:
   ```bash
   docker-compose up -d
   ```

3. Rode a aplicação:
   ```bash
   ./mvnw spring-boot:run
   ```

4. Acesse a API em:
   ```
   http://localhost:8080
   ```

---

##  Endpoints Principais

### Deliveries
- `POST /deliveries` → Cria uma nova entrega
- `GET /deliveries/{id}` → Busca entrega por ID
- `PATCH /deliveries/{id}/pickup` → Marca como retirada por courier
- `PATCH /deliveries/{id}/delivered` → Finaliza entrega

### Couriers
- `POST /couriers` → Registra um novo entregador
- `GET /couriers/{id}` → Busca entregador por ID
- `PATCH /couriers/{id}/assign` → Atribui entrega ao courier

---

##  Testes
Para rodar os testes automatizados:
```bash
./mvnw test
```

---

##  Postman
Uma coleção de requests do **Postman** está disponível em:
```
/postman/SystemDelivery.postman_collection.json
```

---

##  Diagramas de Domínio
Os principais diagramas UML utilizados no design estão incluídos neste README e também disponíveis na pasta:
```
/docs/uml
```

---

##  Docker
O projeto conta com **docker-compose.yml** para subir o ambiente:
- PostgreSQL
- Aplicação Spring Boot

Para iniciar:
```bash
docker-compose up -d
```

---
 
