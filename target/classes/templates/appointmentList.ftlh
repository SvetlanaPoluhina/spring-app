<#include "parts/security.ftlh">
<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page>
    <#include "parts/menu_admin.ftlh">
    <#if isAdmin>
        <div>

            <p>Список приемов</p>

            <div class="div-main-table">
                <div class="div-str-table"><p>Услуга</p></div>
                <div class="div-str-table"><p>Специалист</p></div>
                <div class="div-str-table"><p>Место приема</p></div>
                <div class="div-str-table"><p>Дата приема</p></div>
                <div class="div-str-table"><p>Начало приема</p></div>
                <div class="div-str-table"><p>Пользователь</p></div>
                <div class="div-str-table"><p>Статус</p></div>
                <div class="div-str-table"><p>Подтверждение</p></div>
                <div class="div-str-table"><p>Отмена</p></div>
            </div>
            <#list appointments>
                <#items as appointment>
                    <div class="div-main-table">
                        <div class="div-str-table">${appointment.doctor.specialization_doc.name_spec}</div>
                        <div class="div-str-table">
                            ${appointment.doctor.user_doctor.lastname}
                            ${appointment.doctor.user_doctor.firstname}
                            ${appointment.doctor.user_doctor.patronymic}
                        </div>
                        <div class="div-str-table">${appointment.doctor.policlinic_doc.address}</div>
                        <div class="div-str-table">${appointment.date_app}</div>
                        <div class="div-str-table">${appointment.start_app}</div>
                        <div class="div-str-table">${appointment.patient_app.policy_number}</div>
                        <div class="div-str-table">${appointment.status_appointment.app_status}</div>
                        <div class="div-str-table"><a href="/appointmentList/update/${appointment.id_appointment}">Подтвердить прием</a></div>
                        <div class="div-str-table"> <a href="/appointmentList/delete/${appointment.id_appointment}">Отменить(удалить) прием</a></div>
                    </div>

                </#items>
            <#else>
                <p> Список пуст </p>
            </#list>
        </div>
    </#if>
</@c.page>