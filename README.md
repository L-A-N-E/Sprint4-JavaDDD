# Macroscan API 🩺

API RESTful desenvolvida em **Java com Spring Boot** para o projeto Macroscan. O objetivo principal é facilitar a geração de relatórios de macroscopia para médicos, automatizando o processo de preenchimento e gerando documentos em PDF. A arquitetura segue o padrão **MVC**.

## ✨ Funcionalidades Principais

* **API RESTful Completa**: Endpoints para gerenciar usuários, pacientes e relatórios (CRUD).
* **Autenticação e Autorização**: Segurança baseada em **JWT (JSON Web Tokens)** para proteger os endpoints.
* **Geração de Relatórios**: Capacidade de gerar relatórios médicos dinamicamente no formato **PDF**.
* **Banco de Dados Embarcado**: Utiliza **H2 Database** em modo arquivo para facilitar o ambiente de desenvolvimento, sem necessidade de configurar um banco de dados externo.
* **Validação de Dados**: Garante a integridade dos dados recebidos através do Spring Validation.

---

## 🛠️ Tecnologias Utilizadas

* **Java 11**
* **Spring Boot**: Framework principal para a construção da aplicação.
* **Spring Data JPA**: Para persistência de dados.
* **Spring Security**: Para implementação da segurança com JWT.
* **Maven**: Gerenciador de dependências e build do projeto.
* **H2 Database**: Banco de dados relacional em memória/arquivo.
* **Lombok**: Para reduzir código boilerplate (getters, setters, construtores).
* **iTextPDF**: Biblioteca para a criação e manipulação de arquivos PDF.
* **JSON Web Token (jjwt)**: Para a implementação da autenticação.

---

## 📋 Pré-requisitos

Antes de começar, garanta que você tenha as seguintes ferramentas instaladas em seu ambiente de desenvolvimento:

* **Java Development Kit (JDK)** - **Versão 11** ou superior.
* **Apache Maven** - Para gerenciar as dependências e o build do projeto.
* **Git** - Para clonar o repositório.
* **Plugin Lombok na sua IDE** (Opcional, mas altamente recomendado): Se você usa IntelliJ, Eclipse ou VSCode, instalar o plugin do Lombok evitará erros de compilação na IDE.

---

## 🚀 Como Começar

Siga os passos abaixo para executar o projeto localmente.

1.  **Clone o repositório:**
    ```sh
    git clone [https://github.com/L-A-N-E/Sprint4-JavaDDD.git](https://github.com/L-A-N-E/Sprint4-JavaDDD.git)
    ```

2.  **Navegue até o diretório do projeto:**
    ```sh
    cd Sprint4-JavaDDD
    ```

3.  **Instale as dependências com o Maven:**
    O comando `clean` remove compilações antigas e o `install` baixa todas as dependências do `pom.xml`.
    ```sh
    mvn clean install
    ```

4.  **Execute a aplicação:**
    ```sh
    mvn spring-boot:run
    ```
    A aplicação será iniciada e estará disponível em `http://localhost:8080`.

---

## ⚙️ Uso e Configuração

### Banco de Dados H2

A aplicação utiliza um banco de dados H2 que salva os dados em um arquivo local na pasta `./data/relatoriosdb`.

Você pode acessar o console web do H2 para visualizar e gerenciar os dados diretamente pelo navegador:

* **URL**: `http://localhost:8080/h2-console`
* **JDBC URL**: `jdbc:h2:file:./data/relatoriosdb` (copie e cole este valor no campo "JDBC URL")
* **User Name**: `sa`
* **Password**: (deixe em branco)

### Endpoints da API

A API possui endpoints para autenticação e gerenciamento de recursos.

* `POST /auth/login` - Para autenticar um usuário e receber um token JWT.
* `POST /auth/register` - Para registrar um novo usuário.
* `/api/relatorios` - Endpoints para gerenciar os relatórios (requer autenticação).
* *(Adicione aqui outros endpoints importantes)*

> **Dica**: Utilize uma ferramenta como [Postman](https://www.postman.com/) ou [Insomnia](https://insomnia.rest/) para testar os endpoints da API.

---

### 🧪 Executando os Testes

Para rodar a suíte de testes automatizados e garantir que tudo está funcionando como esperado, execute o seguinte comando:

```sh
mvn test
```

### 🔑 Configuração de Segurança (JWT)

O segredo e o tempo de expiração do token JWT estão configurados no arquivo src/main/resources/application.properties.

```sh
# JWT
jwt.secret=404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970
jwt.expiration=86400000
```
**Atenção**: Para um ambiente de produção, é altamente recomendável não deixar o segredo JWT diretamente no código. Utilize variáveis de ambiente ou um serviço de gerenciamento de segredos.