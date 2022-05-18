<#include "parts/security.ftlh">
<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page>
    <#include "parts/menu_admin.ftlh">
    <div class="button_otstup">
    <form action="/appointmentDiary">
        <button>Дневник приемов специалиста</button>
    </form>

    <form action="/appointmentList">
        <button>Подтверждение записей на прием (список приемов)</button>
    </form>
        </div>
</@c.page>