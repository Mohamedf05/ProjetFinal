<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<style>
#navAthlete{
  display:flex;
}

.event{
border-style: solid;
border-color: black;
display:flex;
}

</style>

<div id="navAthlete">
  <div> Mes menus </div>
  <div><a href='evenement.jsp'><input id="btnMesEvents" type="button" value="Mes events"></a></div>
  <div><a href='score.jsp'><input id="btnMesPerf" type="button" value="Mes performances"></a></div>
  <div><a href='evenement.jsp'><input id="btnPartage" type="button" value="Partager avec un ami"></a></div>
  <div><a href='spectateur.jsp'><input id="btnSwitch" type="button" value="Passer en mode spectateur"></a></div>
</div>

<br>

<div>Vos évènements à venir</div>
<div id="EventList">
  <a href='evenement.jsp'><div class="event">
    <img src="assets/imgEvent/Event1.jpg" alt="Image event1" width="100">Event 1
  <br>Jogging au bois de Chais-pas-quoi
  <br>Jeudi 36 Mars 2041 - 10h</div></a>
  <a href='evenement.jsp'><div class="event">
    <img src="assets/imgEvent/Event2.jpg" alt="Image event2" width="100">Event 2
<br>Grand chelem de Strasbourg
<br>Jeudi 342 Mars 2022 à Vendredi 356 Mars 2022</div></a>
  <a href='evenement.jsp'><div class="event">
    <img src="assets/imgEvent/Event3.jpg" alt="Image event3" width="100">Event 3
<br>Tir à l'arc de Lilles
<br>Jeudi 65 Juillet 2120 - 15h</div></a>
</div>

<br>

<div id="navAthlete">
  <div> Mes évènements passés </div>
  <div><input id="btnClassAnnee" type="button" value="Classer par date"></a></div>
  <div><input id="btnClassDisc" type="button" value="Classer par discipline"></a></div>
  <div><a href='evenement.jsp'><input id="btnFiltrer" type="button" value="Filtrer"></a></div>
</div>
<div id="EventNow">
  <a href='evenement.jsp'><div class="event">
2022<br>
Aucun évènement
</div></a>
<div id="PastEvent">
  <a href='event1.jsp'><div class="event">
    <img src="assets/imgEvent/Event1.jpg" alt="Image event1" width="100">Event 1
  <br>Jogging au bois de Chais-pas-quoi
  <br>Jeudi 36 Mars 2041 - 10h</div></a>
</div>

<br>

<div>Évènements recommandés pour vous !</div>
<div id="EventList">
  <a href='evenement.jsp'><div class="event">
    <img src="assets/imgEvent/Event1.jpg" alt="Image event1" width="100">Event 1
  <br>Jogging au bois de Chais-pas-quoi
  <br>Jeudi 36 Mars 2041 - 10h</div></a>
  <a href='evenement.jsp'><div class="event">
    <img src="assets/imgEvent/Event2.jpg" alt="Image event2" width="100">Event 2
<br>Grand chelem de Strasbourg
<br>Jeudi 342 Mars 2022 à Vendredi 356 Mars 2022</div></a>
  <a href='evenement.jsp'><div class="event">
    <img src="assets/imgEvent/Event3.jpg" alt="Image event3" width="100">Event 3
<br>Tir à l'arc de Lilles
<br>Jeudi 65 Juillet 2120 - 15h</div></a>
</div>

</body>
</html>