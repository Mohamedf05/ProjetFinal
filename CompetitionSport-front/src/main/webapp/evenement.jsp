
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>

*{
    margin: 0;
    padding: 0;
    box-sizing: border-box;
 }

 p
 {
 	color:#3598dc;
 	font-size:20px;
 }

  .evenements
  {
    display:flex;
    justify-content:space-around;
    width:100%;
  }

  #formulaireAjoutEvenement
  {
    display:none;
    background-color:#eff2f3;
    width:22%;
    height:300px;
    margin-bottom: 100px;
    margin-left: 40%;

  }

  #EvenementsEnCours,#EvenementsAVenir,#EvenementsPasses
  {
    width:30%;
    height : 300px;
    background-color:beige;
  }

 body
 {
  background-image: url("img/colisee.jpg");
 }


</style>


<body>
<div>
    <button id="NouvelEvenement" class="btn btn-info" type="button" name="NouvelEvenement">Nouvel évènement</button>
</div>
<br>


<div class="evenements">


  <div id="EvenementsEnCours">
  		<p><b>Evénements en cours</b></p>

  		<c:forEach items="${listeEvenement}" var="evenement">

			<c:choose>

				<c:when test="${evenement.dateDebut<=LocalDate.now() and evenement.dateFin>=LocalDate.now()}">

			      	<table>
					  <tr>
					    <th>${evenement.nom}</th>
					  </tr>
					  <tr>
					    <td>${evenement.ville}</td>
					  </tr>
					  <tr>
					    <td>date de fin &nbsp ${evenement.dateFin}</td>
					  </tr>
					  <tr>
					    <td><a href="animal?id=${evenement.id}"><button class="btn btn-dark" type="button" name="button">Consulter</button></a></td>
					  </tr>
			  		</table>

			  	</c:when>
			  </c:choose>
		 </c:forEach>

  </div>

  <div id="EvenementsAVenir">
    <p><b>Evénements à venir</b></p>

    <c:forEach items="${listeEvenement}" var="evenement">

			<c:choose>

				<c:when test="${evenement.dateDebut>=LocalDate.now()}">

			      	<table>
					  <tr>
					    <th>${evenement.nom}</th>
					  </tr>
					  <tr>
					    <td>${evenement.ville}</td>
					  </tr>
					  <tr>
					    <td>date de debut &nbsp${evenement.dateDebut}</td>
					  </tr>
					  <tr>
					    <td><a href="animal?id=${evenement.id}"><button class="btn btn-dark" type="button" name="button">Consulter</button></a></td>
					  </tr>
			  		</table>

			  	</c:when>
			  </c:choose>
		 </c:forEach>
  </div>

  <div id="EvenementsPasses">
    <p><b>Evénements passés</b></p>

    <c:forEach items="${listeEvenement}" var="evenement">

			<c:choose>

				<c:when test="${evenement.dateFin<LocalDate.now()}">

			      	<table>
					  <tr>
					    <th>${evenement.nom}</th>
					  </tr>
					  <tr>
					    <td>${evenement.ville}</td>
					  </tr>
					  <tr>
					    <td>date de debut &nbsp ${evenement.dateDebut}</td>
					  </tr>
					   <tr>
					    <td>date de fin &nbsp ${evenement.dateDebut}</td>
					  </tr>
					  <tr>
					    <td><a href="animal?id=${evenement.id}"><button class="btn btn-dark" type="button" name="button">Consulter</button></a></td>
					  </tr>
			  		</table>

			  	</c:when>
			  </c:choose>
		 </c:forEach>
  </div>

</div>

</body>

<form method="post" action="evenement" id="formulaireAjoutEvenement" >
	<input type="hidden" name="tache" value="save">

  <fieldset id="fieldset">
  <legend>Ajout d'un nouvel événement</legend>
    <table>
      <tr>
        <th>Nom</th>
        <td><input required type="text" name="nom" value="nom"></td>
      </tr>
      <tr>
        <th>Date début</th>
        <td><input required type="date" name="dateDebut" min="${LocalDate.now()}" value=""></td>
      </tr>
      <tr>
        <th>Date fin</th>
        <td><input required type="date" name="dateFin" min="${datedebut}"  value=""></td>
      </tr>
      <tr>
        <th>ville</th>
        <td><input required type="text" name="ville" value="ville"></td>
      </tr>
      <tr>
        <th></th>
        <td><input class="btn btn-success" type="submit" name="Ajouter" value="Ajouter"></td>
      </tr>
    </table>
  </fieldset>

</form>



<script>
NouvelEvenement.onclick=AjouterEvenement;
function AjouterEvenement()
{
  EvenementsEnCours.style.display="none";
  EvenementsAVenir.style.display="none";
  EvenementsPasses.style.display="none";
  formulaireAjoutEvenement.style.display="flex";
}

</script>
