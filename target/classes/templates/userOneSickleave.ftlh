<#include "parts/security.ftlh">
<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page>
    <#if !isAdmin>
        <#include "parts/menu.ftlh">
    </#if>
    <#if isAdmin>
        <#include "parts/menu_admin.ftlh">
    </#if>
    <div class="loginn">
        <p>ЛИСТОК НЕТРУДОСПОСОБНОСТИ</p>
        <div>
            <div><p>${policlinic_sickName!'Не указано'}</p></div>
            <div><p>Дата выдачи: ${date_sick!'Не указано'}</p><p>${ogrn!'Не указано'}</p></div>
            <div><p>ФИО${patient_sickName!'Не указано'}</p></div>
            <div><p>Дата рождения: ${birthday!'Не указано'}</p></div>
            <div><p>Причина нетрудоспособности: ${code_sickName!'Не указано'} </p></div>
            <div><p>Место работы ${place_work!'Не указано'}</p></div>
            <div><p>С какого числа: ${start_sick!'Не указано'}</p></div>
            <div><p>По какое число: ${end_sick!'Не указано'}</p></div>
            <div><p>ФИО врача: ${doctor_sickName!'Не указано'}</p></div>
        </div>
        <a href="#" onclick="history.back();return false;">Вернуться назад</a>
    </div>

</@c.page>