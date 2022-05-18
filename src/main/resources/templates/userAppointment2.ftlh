<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page>
    <#include "parts/menu.ftlh">
    <div class="loginn">
        <p>Запись на прием</p>

        <form name="form2" action="/userAppointment2/${policlinic_app}/${usluga}" method="post">
            <div class="vvod">
                <label>
                    Выберите специалиста:
                    <select name="doctorssort">
                        <option selected value=0 >Выберите специалиста</option>
                        <#list doctorssort>
                            <#items as doctori>
                                <div class="vvod"><option value="${doctori.id_doctor}">${doctori.user_doctor.lastname} ${doctori.user_doctor.firstname} ${doctori.user_doctor.patronymic}</option></div>
                            </#items>
                            <#else>
                                <div class="vvod"><option value="0">Нет доступного специалиста. Пожалуйста, выберите другое учреждение или услугу.</option></div>
                        </#list>
                    </select>
                </label>
            </div>
            <div class="vvod"><label>Выберите дату приема: <input type="date" name="date_app_str" /></label></div>
            <input type="button" value="Далее" onclick="location.href='http://localhost:8080/userAppointment3/'+escape(document.forms['form2'].elements['doctorssort'].value)+'/'+escape(document.forms['form2'].elements['date_app_str'].value)">
        </form>

        <a href="#" onclick="history.back();return false;">Вернуться назад</a>
    </div>

</@c.page>