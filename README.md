# MCK Clinic (Versão Thymeleaf)

## Aplicação Web desenvolvida em Java com Spring Boot utilizando o template engine Thymeleaf para renderização do frontend.

![Badge em Desenvolvimento](http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge)

## Índice
<!--ts-->
* [Sobre o projeto](#Sobre)
* [Funcionalidades](#Funcionalidades)
* [Layout das telas](#Layout)
* [Tecnologias utilizadas](#Tecnologias)
* [Acesso ao projeto](#Acesso_ao_projeto)
* [Pré-requisitos](#Pre-requisitos)
* [Instruções para download e execução do projeto](#Instruções)
* [Autor](#Autor)
<!--te-->

## Sobre o projeto
Este projeto está sendo desenvolvido para fins de aperfeiçoamento e prática em desenvolvimento web, o mesmo utiliza tecnologias como Java e Spring Boot.<br>
O case utilizado como modelo de negócio para esta aplicação é totalmente fictício e todas as informações, bem como as referências e nomes contidos neste são meramente ilustrativos.<br>
Todas as imagens utilizadas possuem licença de utilização gratuita e foram adquiridas no site da [Adobe Stock](https://stock.adobe.com/pt). 

<a id="Funcionalidades"></a>
## 🔨 Funcionalidades
- Segurança com autenticação básica via JDBC e Spring Security;
- Cadastro de usuarios;
- Validação de cadastro único por cpf;
- Agendamento de consultas;
- Gerenciamento de médicos e especialidades;
- Validação dos agendamentos por horário e data do paciente e médico;
- Histórico de consultas por paciente;
- Confirmação da consulta pelo operador do sistema;
- Envio de e-mail de confirmação de cadastro;
- Envio de e-mail de notificação de agendamento de consultas;

<a id="Layout"></a>
## 💻 Layout da aplicação
### ✅ Tela Inicial
![](https://raw.githubusercontent.com/Melquisedeque-Marins/MCK-Clinic-Thymeleaf/main/utils/Home-screen.png)
### ✅ Tela Sobre
![](https://raw.githubusercontent.com/Melquisedeque-Marins/MCK-Clinic-Thymeleaf/main/utils/About-screen.png)
### ✅ Tela de Cadastro
![](https://raw.githubusercontent.com/Melquisedeque-Marins/MCK-Clinic-Thymeleaf/main/utils/Register-screen.png)
### ✅ Tela de Login
![](https://raw.githubusercontent.com/Melquisedeque-Marins/MCK-Clinic-Thymeleaf/main/utils/Login-screen.png)
## 🚧 Projeto em construção 🚧
### Demais telas em desenvolvimento 
<a id="Tecnologias"></a>
## 🛠️️ Tecnologias e linguagens utilizadas

- Java 17
- Spring Boot 2.4.4
- Thymeleaf
- HTML 5
- CSS 3
- JavaScript
- PostgreSQL
- Postman
- Heroku CLI
- Docker
- InteliJ IDEA
- VS Code IDE

<a id="Acesso_ao_projeto"></a>
## 📁 Acesso ao projeto

Você pode acessar o código fonte do projeto clicando [aqui](https://github.com/Melquisedeque-Marins/MCK-Clinic-Thymeleaf/tree/main/src).

<a id="Pre-requisitos"></a>
## ✔ Pré-requisitos

✔️ **JDK 17**

✔️ **Acesso à internet**

<a id="Instruções"></a>
## 🎲️ Instruções para download e execução do projeto

- Abra o terminal e navegue até o diretório onde deseja salvar o projeto
  ``$ cd /"caminho do diretório"``.
- Faça o clone o repósitório
  ``$ git clone https://github.com/Melquisedeque-Marins/MCK-Clinic-Thymeleaf.git``
- Acesse a pasta do projeto terminal/cmd
  ``$ cd /MCK-Clinic-Thymeleaf``.
- Execute o seguinte comando caso não tenha o maven instalado
  ``$ ./mvnw clean package spring-boot:run``.
- Caso contrário
  ``$ mvn clean package spring-boot:run``.
- O servidor Toncat do projeto será inicializado na porta
  ``8080``
  do seu computador.


<a id="Autor"></a>
## Autor
<a href="https://github.com/Melquisedeque-Marins">
 <img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/93653645?v=4" width="120px;" alt=""/>
<br />
 <sub><b>Melquisedeque Marins Junior</b></sub></a> <a href="https://www.linkedin.com/in/melquisedeque-marins-junior-324291230"></a>

[![Linkedin](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/melquisedeque-marins-junior-324291230)
