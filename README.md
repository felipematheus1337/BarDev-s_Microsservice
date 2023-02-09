# BarDev-s_Microsservice
<h5>Um Sistema de bar de desenvolvedores que consome API Externas com Cervejas, que é a: https://punkapi.com/documentation/v2 com regras de negócios específicas, baseado no retorno do consumo dessa API Externa, tais como: </h5>

<p>- Buscar cervejas com certo teor alcólico específico.</p>
<p>- Buscar cervejas com certa cor específica.</p>
<p>- Buscar cerveja  com certo sabor específico.</p>
<h5>E todas essas buscas com lógica de negócio baseada nos valores de IBU,ABV && EBC.</h5>

## Tecnologias Utilizadas
<div style="display: inline_block" align="left">
 <img  alt="lipe-Js" height="80" width="80" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-plain.svg">
 <img  alt="lipe--CSS" height="80" width="80" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/spring/spring-original.svg">
 <img  alt="lipe--CSS" height="80" width="80" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/mongodb/mongodb-original.svg">
 <img src="https://pbs.twimg.com/media/D3-5yUUWAAAICtE.png" alt="postgresql" width="80" height="80"/>
</div> 


## Pré-Requisitos
<p>Maven 3.6 >
<p>Java 17</p>
<p>MongoDB local ou MongoDB Atlas</p>


## Features / Funcionalidades
<p>Consumo de WebServices</p>
<p>Validação dos dados</p>
<p>DDD</p>
<p>SOLID</p>
<p>Tratamento personalizado de Exceção</p>
<p>Documentação com Swagger</p>
<p>CRUD</p>
<p>Autenticação com JWT em breve...</p>

<hr/>

### Model da Collection
<img src="https://github.com/felipematheus1337/BarDev-s_Microsservice/blob/dev/docs/collection.jpeg?raw=true" />

### Documentação da API
<img src="https://github.com/felipematheus1337/BarDev-s_Microsservice/blob/dev/docs/swagger.jpeg?raw=true" />


## Criando o Jar
mvn clean package

## Executando o Projeto
mvn spring-boot:run

