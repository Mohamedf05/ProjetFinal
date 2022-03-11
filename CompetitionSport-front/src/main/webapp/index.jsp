<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
 	<link rel="stylesheet" href="style.css">
    <link rel="icon" href="img/logo3.jpg">
    <title>Accueil SportEvents</title>
 </head>
  



<body>
<header>
<div id="banniere">

  <a href="index.jsp"><div id="logo"><img src="img/logo3.jpg" alt="logo"></div></a>

    <div class="menuBanniere">
      <table>
        <tr>
          <td><button type="button" name="button"><a href="connexion.jsp">Se connecter</a></button></td>
          <td><button type="button" name="button"><a href="inscriptionAtlete.jsp">Créer un compte</a></button></td>
        </tr>
      </table>
    </div>
  </div>
</header>
<br>
  <div id="myCarousel" class="carousel slide border" data-ride="carousel">
   <div class="carousel-inner">
      <div class="carousel-item active">
        <div class="carousel-orga">
        <h5>Organisateur</h5>
        <p>Vous êtes organisateur d'évènements et vous voulez créer un évènement digne des Jeux Olympiques alors lancez vous !</p>
        </div>
        <a href="organisateur.jsp"><img class="d-block w-100" src="img/Sportcitation.jpg" alt="Sportcitation"></a>
      </div>
      
      <div class="carousel-item">
      <div class="carousel-event">
        <h5>Évènements</h5>
        <p>Pour suivre tous les évènements à la une et ne rien rater des compétitions proche de chez vous.</p>
        </div>
        <a href="evenement.jsp"><img class="d-block w-100" src="img/colisee.jpg" alt="Colisee"></a>
      </div>
      
       <div class="carousel-item">
        <div class="carousel-athlete">
        <h5>Athlètes</h5>
        <p>Vous êtes athlètes et vous souhaitez participer à des évènements sur mesure ? N'attendez plus pour vous inscrire !</p>
        </div>
         <a href="athlete.jsp"><img class="d-block w-100" src="img/coupe.jpg" alt="Coupe"></a>
      </div>
   </div>
   <!-- Controls -->
   <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
     <span class="carousel-control-prev-icon" aria-hidden="true"></span>
     <span class="sr-only">Previous</span>
   </a>
   <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
     <span class="carousel-control-next-icon" aria-hidden="true"></span>
     <span class="sr-only">Next</span>
   </a>
  </div>
<body>
