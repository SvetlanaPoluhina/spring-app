<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page>
    <#include "parts/menu.ftlh">

    <div>
        <p>Мои прививки</p>
        <div class="div-main-table">
            <div class="div-str-table-vac"><p>Прививка</p></div>
            <div class="div-str-table-vac"><p>Препарат</p></div>
            <div class="div-str-table-vac"><p>Дата</p></div>
            <div class="div-str-table-vac"><p>Доза</p></div>
            <div class="div-str-table-vac"><p>Страна изготовитель</p></div>
            <div class="div-str-table-vac"><p>Результат</p></div>
            <div class="div-str-table-vac"><p>Место проведения</p></div>
            <div class="div-str-table-vac"><p>Врач</p></div>
            <div class="div-str-table-vac"><p>Пользователь</p></div>
        </div>
        <#list vaccines>
            <#items as vaccine>
                <div class="div-main-table">
                    <div class="div-str-table-vac">${vaccine.name_vaccine}</div>
                    <div class="div-str-table-vac">${vaccine.name_preparate}</div>
                    <div class="div-str-table-vac">${vaccine.date}</div>
                    <div class="div-str-table-vac">${vaccine.dose_vaccine}</div>
                    <div class="div-str-table-vac">${vaccine.country_vaccine}</div>
                    <div class="div-str-table-vac">${vaccine.result_tuberdiagnoz}</div>
                    <div class="div-str-table-vac">${vaccine.poliklinikName}</div>
                    <div class="div-str-table-vac">${vaccine.admin_vacName}</div>
                    <div class="div-str-table-vac">${vaccine.patient_vacName}</div>
                </div>

            </#items>
        <#else>
            <p> Список пуст </p>
        </#list>
    </div>
</@c.page>