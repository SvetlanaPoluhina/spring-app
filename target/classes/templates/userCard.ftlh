<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page>
<#include "parts/menu_admin.ftlh">

    <div class="button_otstup">
        <p>Личные данные</p>
        <div class="info"><p>Фамилия: ${lastname!''}</p></div>
        <div class="info"><p>Имя: ${firstname!''}</p></div>
        <div class="info"><p>Отчество: ${patronymic!''}</p></div>
        <div class="info"><p>Дата рождения: ${birthday!''}</p></div>
        <div class="info"><p>Номер полиса ОМС: ${policy_number!''}</p></div>
        <div class="info"><p>Контактный телефон: ${phone!''}</p></div>
        <p>Доп.информация</p>
        <div class="info"><p>Группа крови: ${group_blood!"Не указано"}</p></div>

        <p>Мои заключения</p>
        <div class="div-main-table">
            <div class="div-str-table"><p>Дата</p></div>
            <div class="div-str-table"><p>Специалист</p></div>
            <div class="div-str-table"><p>Заключение</p></div>
        </div>
        <#list reports>
            <#items as report>
                <div class="div-main-table">
                    <div class="div-str-table">${report.date_report}</div>
                    <div class="div-str-table">${report.doctor_repName}</div>
                    <div class="div-str-table"> <a href="/report/${report.id_med_report}">Перейти к документу</a></div>
                </div>

            </#items>
        <#else>
            <p> Список пуст </p>
        </#list>

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

        <p>Мои анализы</p>
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
        <form action="/report">
            <button>Добавить заключение</button>
        </form>
        <form action="/sickleave">
            <button>Добавить больничный лист</button>
        </form>
    </div>
</@c.page>