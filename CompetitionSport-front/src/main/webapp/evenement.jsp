
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<style>
  .evenements
  {
    display:flex;
    justify-content:space-around;
    width:100%;
  }

  #formulaireAjoutEvenement
  {
    display:none;
  }
  #EvenementsEnCours,#EvenementsAVenir,#EvenementsPasses
  {
    width:30%;
    height : 300px;
    background-color:#eff2f3;
  }

</style>


<html>
<div>
    <button id="NouvelEvenement" class="btn btn-info" type="button" name="NouvelEvenement">Nouvel évènement</button>
</div>
<br>


<div class="evenements">


  <div id="EvenementsEnCours">
  		<p>Evénements en cours</p>
  		
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
					    <td><a href="animal?id=${evenement.id}&action='consulter'"><button class="btn btn-dark" type="button" name="button">Consulter</button></a></td>
					  </tr>
			  		</table>
			  		
			  	</c:when>
			  </c:choose>
		 </c:forEach>
			  		
  </div>

  <div id="EvenementsAVenir">
    <p>Evénements à venir</p>
    
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
					    <td><a href="animal?id=${evenement.id}&action='consulter'"><button class="btn btn-dark" type="button" name="button">Consulter</button></a></td>
					  </tr>
			  		</table>
			  		
			  	</c:when>
			  </c:choose>
		 </c:forEach>
  </div>

  <div id="EvenementsPasses">
    <p>Evénements passés</p>
    
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
					    <td><a href="animal?id=${evenement.id}&action='consulter'"><button class="btn btn-dark" type="button" name="button">Consulter</button></a></td>
					  </tr>
			  		</table>
			  		
			  	</c:when>
			  </c:choose>
		 </c:forEach>
  </div>

</div>

</html>

<form  id="formulaireAjoutEvenement" >
  
  <fieldset>
  <legend>Ajout d'un nouvel animal</legend>
    <table>
      <tr>
        <th>Nom</th>
        <td><input required type="text" name="nom" value=""></td>
      </tr>
      <tr>
        <th>Date début</th>
        <td><input required type="date" name="dateDebut" value=""></td>
      </tr>
      <tr>
        <th>Date fin</th>
        <td><input required type="date" name="dateFin" value=""></td>
      </tr>
      <tr>
        <th>ville</th>
        <td><input required type="text" name="ville" value=""></td>
      </tr>
      <tr>
        <th></th>
        <td>  <a href="evenement"><input class="btn btn-success" type="submit" name="Ajouter" value="Ajouter"></a></td>
      </tr>
    </table>
  </fieldset>

</form>



<script>
NouvelEvenement.onclick=AjouterEvenement;
function AjouterEvenement()
{
  formulaireAjoutEvenement.style.display="block";
}

</script>
