<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<#include "parts/security.ftlh">

<@c.page>
    <#if !isAdmin>
        <#include "parts/menu.ftlh">
    </#if>
    <#if isAdmin>
        <#include "parts/menu_admin.ftlh">
    </#if>
        <div class="loginn">
            <h>Личные данные</h>
            <div class="info"><p>Фамилия: ${lastname!''}</p></div>
            <div class="info"><p>Имя: ${firstname!''}</p></div>
            <div class="info"><p>Отчество: ${patronymic!''}</p></div>
            <div class="info"><p>Дата рождения: ${birthday!''}</p></div>
            <div class="info"><p>Номер полиса ОМС: ${policy_number!''}</p></div>
            <div class="info"><p>Контактный телефон: ${phone!''}</p></div>
            <div class="info"><p>Электронная почта: ${email!''}</p></div>
            <div class="info"><p>Группа крови: ${group_blood!"Не указано"}</p></div>
            <form action="/userProfileEdit">
                <button>Изменить свои данные</button>
            </form>
        </div>


</@c.page>