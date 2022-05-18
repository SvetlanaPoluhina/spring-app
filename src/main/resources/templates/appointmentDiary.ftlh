<#include "parts/security.ftlh">
<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page>
    <#include "parts/menu_admin.ftlh">
    <#if isDoctor>
        <div>
            <div class="button_otstup">
                <form name="form_date" action="/appointmentDiary" method="post">
                    <div class="vvod"><label>Выберите дату: <input type="date" name="date_app" /></label></div>
                    <input type="button" value="Перейти" onclick="location.href='http://localhost:8080/appointmentDiary/'+escape(document.forms['form_date'].elements['date_app'].value)">
                </form>
            </div>

            <p>Список текущих приемов</p>

            <div class="div-main-table">
                <div class="div-str-table"><p>Начало приема</p></div>
                <div class="div-str-table"><p>Пациент</p></div>
                <div class="div-str-table"><p>Перейти к приему</p></div>
            </div>
            <#list appointments>
                <#items as appointment>
                    <div class="div-main-table">
                        <div class="div-str-table">${appointment.start_app}</div>
                        <div class="div-str-table">
                            ${appointment.patient_app.lastname}
                            ${appointment.patient_app.firstname}
                            ${appointment.patient_app.patronymic}
                        </div>
                        <div class="div-str-table"> <a href="/appointment/${appointment.id_appointment}">Перейти</a></div>
                    </div>

                </#items>
            <#else>
                <p> Список пуст </p>
            </#list>
        </div>
    </#if>
</@c.page>