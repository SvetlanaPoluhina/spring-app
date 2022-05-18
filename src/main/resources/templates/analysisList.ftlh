<#include "parts/security.ftlh">
<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page>
    <#include "parts/menu_admin.ftlh">
    <#if isAdmin>
        <div>
            <p>Список анализов</p>

            <div class="div-main-table">
                <div class="div-str-table"><p>Описание анализа</p></div>
                <div class="div-str-table"><p>Дата сдачи</p></div>
                <div class="div-str-table"><p>Результат</p></div>
                <div class="div-str-table"><p>Место проведения</p></div>
                <div class="div-str-table"><p>Врач</p></div>
                <div class="div-str-table"><p>Пользователь</p></div>
                <div class="div-str-table"><p>Удалить</p></div>
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
                        <div class="div-str-table"> <a href="/analysisList/delete/${analysis.idanalysis}">удалить</a></div>
                    </div>

                </#items>
            <#else>
                <p> Список пуст </p>
            </#list>
        </div>
    </#if>
</@c.page>