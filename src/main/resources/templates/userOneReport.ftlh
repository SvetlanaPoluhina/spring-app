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
        <p>Заключение</p>
        <div>
            <div><p>Пациент: ${patient_repName!'Не указано'}</p></div>
            <div><p>Диагноз(ы): ${diagnoses!'Не указано'}</p></div>
            <div><p>Жалобы ${complaint!'Не указано'}</p></div>
            <div><p>Направление на исследование(я): ${researches!'Не указано'}</p></div>
            <div><p>Рекомендации по лечению: ${treatname!'Не указано'}</p></div>
            <div><p>Заключение: ${status_report!'Не указано'} </p></div>
            <div><p>Повторный прием: ${date_repeated_admission!'Не указано'}</p></div>
            <div><p>Специалист: ${doctor_repName!'Не указано'}</p></div>
            <div><p>Дата приема: ${date_report!'Не указано'}</p></div>
            <div><p>Место приема: ${policlinic_repName!'Не указано'}</p></div>
        </div>
        <a href="#" onclick="history.back();return false;">Вернуться назад</a>
    </div>

</@c.page>