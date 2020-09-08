# Desafio fullstack André Masiero

Sistema de gerenciamento de processos

# Tecnologias Utilziadas no back-end
  Java 11
  <br>
  Maven 3.6.1
  <br>
  SpringBoot 2.3.3
  <br>
  Spring Security - Data
  <br>
  Banco em memória H2
  <br>
  JPA
  <br>
  Hibernate 5.2.16
  <br>
  Criteria Builder
  <br>
  Swagger 2.9.2
  <br>
  Mockito 1.10.19
  <br><br>
  Padrão MVC composto por camadas de entidades, serviços, repositories e controllers
  <br>
# Tecnologias Utilziadas no front-end
  NODE.JS v14.9.0
  <br>
  Angular 8
  <br>
  Material Design 8.2.3
  <br><br>
## Sistema de Autenticação
   Spring Security com JWT(Json Web Token)
   
   
 <br><br>
# Comandos para rodar a aplicação
## Back-end
Opção 1 - No pacote raíz do back(softplan-process-manager-back)
<br>
- comando: 'mvn package' (será gerado um jar softplan-process-manager-1.0.0 na pasta ./target)
- Uma vez dentro da pasta target, usar o comando  'java -jar softplan-process-manager-1.0.0.jar'
<br>
Obs.:Dependendo da versão do JDK na máquina, pode dar o seguinte erro: 
Exception in thread "main" java.lang.UnsupportedClassVersionError
<br><br>
Opção 2 - No pacote raíz do back(softplan-process-manager-back)
<br><br>
- comando: 'mvn spring-boot:run', irá subir a aplicação na porta 8080
<br>
Opção 3 - Utilizar uma IDE
<br>
- Executar a classe com o main(SoftplanApplication), irá subir a aplicação na porta 8080
<br>

## Front-end
1 - No pacote raíz do front(softplan-process-manager-front)
<br>
- Baixar as dependencias: 'npm install'
- Subir o front: 'ng serve', irá subir o front na porta 4200

# Telas do sistema
Login: admin@teste.com - triador@teste.com - finalizador@teste.com (todos são senha 123456)
<p align="center">
  <img src="./Documentacao/prints_tela/1 - Login.jpg" alt="accessibility text">
</p>
<br>
Gestão de Usuários - Usuário Admin
<p align="center">
  <img src="./Documentacao/prints_tela/2 - GestaoDeUsuarios-ADMIN.jpg" alt="accessibility text">
</p>
<br>
Cadstro de Usuários - Usuário Admin
<p align="center">
  <img src="./Documentacao/prints_tela/3 - CadastroUsuario-ADMIN.jpg" alt="accessibility text">
</p>
Cadstro de Usuários Exemplo de Validação do formulário - Períl Admin
<p align="center">
  <img src="./Documentacao/prints_tela/4 -CadastroUsuarioValidacao-ADMIN.jpg" alt="accessibility text">
</p>
<br>
Lista de Processos
<p align="center">
  <img src="./Documentacao/prints_tela/5 - ListaDeProcessos.jpg" alt="accessibility text">
</p>
<br>
Cadastro de Processos - Usuário Triador
<p align="center">
  <img src="./Documentacao/prints_tela/6 - CadastroDeProcesso-TRIADOR.jpg" alt="accessibility text">
</p>
<br>
Cadastro de Parecer - Usuário Triador
<p align="center">
  <img src="./Documentacao/prints_tela/7 - CadastroDeParecer-TRIADOR.jpg" alt="accessibility text">
</p>
<br>
Cadastro de Parecer - Usuário Finalizador
<p align="center">
  <img src="./Documentacao/prints_tela/8 - CadastroDeParecer-FINALIZADOR.jpg" alt="accessibility text">
</p>
