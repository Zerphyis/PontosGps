### **Desafio - Pontos de Interesse por GPS**

Este projeto foi desenvolvido como parte do desafio proposto pela empresa XY Inc., especializada em receptores GPS. O objetivo era criar uma plataforma baseada em serviços REST para localizar e gerenciar pontos de interesse (POIs). A plataforma foi construída para ser flexível e facilmente integrada com dispositivos de GPS.

**Requisitos do Desafio:**

- **Cadastrar pontos de interesse**: O sistema permite cadastrar POIs com três atributos: nome, coordenada X e coordenada Y.
- **Listar todos os POIs**: Todos os POIs cadastrados podem ser listados.
- **Listar POIs por proximidade**: O serviço recebe as coordenadas X e Y de um ponto de referência e uma distância máxima (d-max). Ele retorna todos os POIs que estão dentro dessa distância.

**Exemplo de POIs cadastrados**:

- **Lanchonete** (x=27, y=12)
- **Posto** (x=31, y=18)
- **Joalheria** (x=15, y=12)
- **Floricultura** (x=19, y=21)
- **Pub** (x=12, y=8)
- **Supermercado** (x=23, y=6)
- **Churrascaria** (x=28, y=2)

Dado um ponto de referência **(x=20, y=10)** e uma distância máxima de 10 metros, o serviço retornaria os seguintes POIs:

- Lanchonete
- Joalheria
- Pub
- Supermercado

**Para mais detalhes sobre o desafio, acesse o link**: [Desafio Ponto GPS - Requisitos](https://github.com/backend-br/desafios/blob/master/points-of-interest/PROBLEM.md).

## **Tecnologias Utilizadas**

- **Spring Boot** 3.4.4
- **Spring Security**: Para proteger as rotas com autenticação e autorização.
- **Spring Data JPA**: Para o acesso e gerenciamento dos dados no banco de dados.
- **JWT (JSON Web Token)**: Para geração de tokens de autenticação.
- **MySQL**: Banco de dados utilizado para armazenar dados de usuários e POIs.
- **Spring Validation**: Para validações de entrada de dados.

---

## **Estrutura do Projeto**

- **/gps**: Controlador principal para manipulação de POIs (Pontos de Interesse).
  - `/gps` (POST): Cria um novo POI.
  - `/gps` (GET): Retorna todos os POIs.
  - `/gps/buscar/{id}` (GET): Busca um POI por ID.
  - `/gps/{id}` (PUT): Atualiza um POI existente.
  - `/gps/{id}` (DELETE): Exclui um POI.
  - `/gps/proximidade` (GET): Encontra POIs próximos com base em coordenadas e distância máxima.

- **/login**: Controlador para autenticação e registro de usuários.
  - `/login/register` (POST): Registra um novo usuário.
  - `/login/auth` (POST): Autentica um usuário e retorna um token JWT.

---

## **Configuração do Ambiente**

1. **Requisitos**
   - Java 17
   - MySQL ou outro banco de dados configurado no `application.properties`
   - Maven ou outra ferramenta para gerenciar dependências

2. **Configuração do Banco de Dados**
   - Configure a conexão com o banco de dados MySQL no arquivo `src/main/resources/application.properties`:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/nome_do_banco
     spring.datasource.username=usuario
     spring.datasource.password=senha
     spring.jpa.hibernate.ddl-auto=update
     spring.jpa.show-sql=true
     spring.jpa.properties.hibernate.format_sql=true
     ```
---
### Endpoints
#### Autenticação
#### **POST /login/register:**
Registra um novo usuário.
![Image](https://github.com/user-attachments/assets/88ac20b0-b315-4db9-85aa-4735b1ad14b4)
<br>

#### **POST /login/auth:**
Realiza a autenticação de um usuário e retorna um token JWT.
<br>
![Image](https://github.com/user-attachments/assets/607098c3-428f-4ca7-9ed5-c1021b570d1c)

<br>

#### POIs
#### **POST /gps:**
Cria um novo ponto de interesse.
<br>

![Image](https://github.com/user-attachments/assets/3ae4cd4f-ecc8-4a00-91fe-4a8a8bd3d36e)
<br>

#### **GET /gps:**
Retorna todos os pontos de interesse cadastrados.
<br>

![Image](https://github.com/user-attachments/assets/e143c02f-892c-43ad-be8d-6ba80eeb7850)
<br>

#### **GET /gps/buscar/{id}:**
Retorna um POI específico pelo ID.
<br>

![Image](https://github.com/user-attachments/assets/78a43b5d-ca94-493d-bc04-69cb5be4965b)
<br>

#### **PUT /gps/{id}:**
Atualiza as informações de um POI existente.
<br>

![Image](https://github.com/user-attachments/assets/15cc8bd2-32a2-4b61-82c5-3ce5c820ee3a)
<br>
#### **DELETE /gps/{id}:**
Exclui um POI pelo ID.
<br>

![Image](https://github.com/user-attachments/assets/7f8d3f1c-78b8-4104-be9c-b93134ce4fc8)
<br>

#### **GET /gps/proximidade:**
Encontra POIs próximos com base nas coordenadas X e Y e uma distância máxima (dMax).
<br>

![Image](https://github.com/user-attachments/assets/da122f38-7f9f-4551-a1d2-2504fe491a3a)
<br>

