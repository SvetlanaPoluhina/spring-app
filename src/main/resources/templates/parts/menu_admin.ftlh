<#include "security.ftlh">
<#import "login.ftlh" as l>

<nav id="main_menu">
    <ul>
        <li>
            <a href="/">Главная</a>
        </li>
        <li>
            <a href="/menuAppointment">Приемы</a>
        </li>
        <li>
            <a class="" href="/analysis">Анализы</a>
        </li>
        <li>
            <a class="" href="/vaccines">Прививки</a>
        </li>
        <li>
            <a class="" href="/adminAppointment1">Запись</a>
        </li>
        <li>
            <@l.logout />
        </li>
    </ul>
</nav>