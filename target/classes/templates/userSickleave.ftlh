<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page>
    <#include "parts/menu.ftlh">

    <div>
        <p>Мои больничные листы</p>

        <div class="div-main-table">
            <div class="div-str-table"><p>Дата</p></div>
            <div class="div-str-table"><p>Специалист</p></div>
            <div class="div-str-table"><p>Больничный лист</p></div>
        </div>
        <#list sickleaves>
            <#items as sickleave>
                <div class="div-main-table">
                    <div class="div-str-table">${sickleave.date_sick}</div>
                    <div class="div-str-table">${sickleave.doctor_sickName}</div>
                    <div class="div-str-table"> <a href="/sickleave/${sickleave.id_sick_leave}">Перейти к документу</a></div>
                </div>

            </#items>
        <#else>
            <p> Список пуст </p>
        </#list>
    </div>
</@c.page>