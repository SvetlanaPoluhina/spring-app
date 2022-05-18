<#include "parts/security.ftlh">
<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page>
    <#include "parts/menu.ftlh">

    <div class="loginn">
        <p>Список действующих записей на прием</p>
        <div>
            <#list appointments>
                <#items as appointment>
                    <div class="div-main-table">
                        <div class="div-str-table">
                            ${appointment.date_app}
                            <span> в </span>
                            ${appointment.start_app},
                            ${appointment.doctor.specialization_doc.name_spec}
                            ${appointment.doctor.user_doctor.lastname}
                            ${appointment.doctor.user_doctor.firstname}
                            ${appointment.doctor.user_doctor.patronymic},
                            <span> по адресу </span>
                            ${appointment.doctor.policlinic_doc.address},
                            (статус ${appointment.statusAppName})
                        </div>
                    </div>
                </#items>
            <#else>
                <p> Список пуст </p>
            </#list>
        </div>

    </div>
</@c.page>