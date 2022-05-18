<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page>
    <#include "parts/menu.ftlh">

    <div>
        <p>Мои анализы</p>
        <form action="/userAnalysis/${currentUserId}">
            <div class="div-main-table">
                <div class="div-str-table"><p>Описание анализа</p></div>
                <div class="div-str-table"><p>Дата сдачи</p></div>
                <div class="div-str-table"><p>Результат</p></div>
                <div class="div-str-table"><p>Место проведения</p></div>
                <div class="div-str-table"><p>Врач</p></div>
                <div class="div-str-table"><p>Пользователь</p></div>
            </div>
            <#list analysises>
                <#items as analysis>
                    <div class="div-main-table">
                        <div class="div-str-table">${analysis.name_analysis}</div>
                        <div class="div-str-table">${analysis.date_analysis}</div>
                        <div class="div-str-table">${analysis.result}</div>
                        <div class="div-str-table">${analysis.policlinicName}</div>
                        <div class="div-str-table">${analysis.adminName}</div>
                        <div class="div-str-table">${analysis.patientName}</div>
                    </div>

                </#items>
            <#else>
                <p> Список пуст </p>
            </#list>
        </form>
    </div>
</@c.page>