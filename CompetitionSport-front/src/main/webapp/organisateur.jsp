<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
    
 <style>
 body
 {
  background-image: url("img/colisee.jpg");
 }

</style>

 <body>
 <c:if test="${connected.getClass().getSimpleName()!='Organisateur'}">
	<c:redirect url = "home"/>
</c:if>


<title>Menu Organisateur</title>

<main align="center">

<h1>Welcome ${connected.mail}</h1>
<div id="banniere">
  <div> <a href="evenement"><i>"Gestion des évènements"</i></a></div>
  <div> <a href="terrain"><i>"Gestion des terrains"</i></a></div>
  <div> <a href="logement"><i>"Gestion des logements"</i></a> </div>
</div>
<br>
</main>
 
 </body>   
