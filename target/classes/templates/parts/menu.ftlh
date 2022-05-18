<#include "security.ftlh">
<#import "login.ftlh" as l>

<nav id="main_menu">
    <ul>
        <li>
            <a href="/">Главная</a>
        </li>
        <li>
            <a href="/userReport/${currentUserId}">Заключения</a>
        </li>
        <li>
            <a class="" href="/userAnalysis/${currentUserId}">Анализы</a>
        </li>
        <li>
            <a class="" href="/userVaccine/${currentUserId}">Прививки</a>
        </li>
        <li>
            <a class="" href="/userAppointment1">Запись</a>
        </li>
        <li>
            <@l.logout />
        </li>
    </ul>
</nav>