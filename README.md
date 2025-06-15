# 🏆 Tournament Challenge API

API REST desenvolvida para o gerenciamento de **jogadores**, **torneios** e execução de **desafios de lógica**, incluindo **ranking global** e **por torneio**.
Este projeto foi construído com **Spring Boot**, integra banco de dados em memória (H2), possui **testes automatizados com cobertura Jacoco** e segue boas práticas de design e desenvolvimento.

---

## 🚀 Começando

Essas instruções permitirão que você obtenha uma cópia do projeto em operação na sua máquina local para fins de **desenvolvimento** e **testes**.

Consulte [📦 Implantação](#-implantação) para saber como implantar o projeto.

---

## 📋 Pré-requisitos

Para executar este projeto, você precisa ter instalado:

* **Java 17+**
* **Maven 3.8+**
* Git (opcional)

---

## 🔧 Instalação

Siga os passos abaixo para executar o ambiente localmente:

1. Clone o repositório:

   ```bash
   git clone https://github.com/FabioRamos10/backend-tournament.git
   cd backend-tournament
   ```

2. Execute a aplicação com Maven:

   ```bash
   mvn spring-boot:run
   ```

3. Acesse o Swagger da API:

   ```
   http://localhost:8080/swagger-ui.html
   ```

### Demonstração:

* Crie um jogador via `POST /players`
* Crie um torneio via `POST /tournaments`
* Execute um desafio via `POST /challenges/execute`
* Veja o ranking em `GET /ranking/global`

---

## ⚙️ Executando os testes

Execute os testes automatizados com:

```bash
mvn clean verify
```

Esse comando:

* Roda testes com JUnit 5 e Mockito
* Gera relatório Jacoco de cobertura
* Usa banco de dados em memória (H2)

---

## 🔩 Análise dos testes de ponta a ponta

Os testes automatizados validam:

* Regras de negócio nos services
* Endpoints via controllers
* Lógica dos desafios matemáticos
* Cobertura mínima de 60% de código com Jacoco

Exemplo de teste:

```java
@Test
void shouldReturnFibonacciValue() {
    var dto = new ChallengeRequestDTO("fibonacci", "10", 1L, 1L);
    var result = challengeService.executeChallenge(dto);
    assertEquals("55", result.getResult());
}
```

---

## ⌨️ Testes de estilo de codificação

O projeto segue padrões limpos de codificação Java com:

* Convenções de nomenclatura (`camelCase`)
* Separacão de camadas (controller, service, model)
* DTOs com testes unitários diretos
* Serviços com testes usando Mockito

---

## 📦 Implantação

Para implantar a aplicação em ambiente produtivo:

1. Gere o pacote `.jar`:

   ```bash
   mvn clean package
   ```

2. Execute com:

   ```bash
   java -jar target/backend-0.0.1-SNAPSHOT.jar
   ```

3. Configure variáveis de ambiente como `DB_URL`, `PORT`, etc., conforme necessário para seu servidor de produção.

---

## 🛠️ Construído com

* **Spring Boot** – Framework principal
* **Spring Data JPA** – Acesso a dados
* **H2 Database** – Banco de dados em memória
* **Lombok** – Redução de boilerplate
* **Maven** – Gerenciador de dependências
* **JUnit 5 & Mockito** – Testes
* **Jacoco** – Cobertura de código
* **Swagger/OpenAPI** – Documentação da API

---

## 🔇 Colaborando

Por favor, leia o arquivo `COLABORACAO.md` para conhecer o nosso código de conduta e o processo para enviar Pull Requests.

---

## 📌 Versão

Este projeto segue a convenção de versionamento **[SemVer](https://semver.org/lang/pt-BR/)**.
A versão atual é `0.0.1-SNAPSHOT`.

---

## ✂️ Autores

* **Fabio Filho Eterno Ramos** – Trabalho inicial, desenvolvimento completo
  [GitHub – FabioRamos10](https://github.com/FabioRamos10)

Você também pode ver a lista de [todos os colaboradores](https://github.com/FabioRamos10/backend-tournament/graphs/contributors) que participaram deste projeto.

---

## 📄 Licença

Este projeto está licenciado sob os termos da **Licença MIT** – veja o arquivo [LICENSE.md](LICENSE.md) para detalhes.

---


