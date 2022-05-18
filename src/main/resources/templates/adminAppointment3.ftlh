<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page>
    <#include "parts/menu_admin.ftlh">
    <div class="loginn">
        <p>Запись на прием</p>

        <form action="/adminAppointment3/${doctori}/${date_app_str}" method="post">
            <input type="hidden" value="${doctori}" name="doctor"/>
            <input type="hidden" value="${date_app_str}" name="date_app" />
            <input type="hidden" value="2" name="status_appointment" />
            <div class="vvod">
                <label>
                    Выберите время приема:
                    <!--input type="time" name="start_app" /-->
                    <select type="time" name="start_app">
                        <option selected value=0 >Выберите время</option>
                        <#list schedulesort>
                            <#items as time>
                                <div class="vvod"><option value="${time}">${time}</option></div>
                            </#items>
                        <#else>
                            <div class="vvod"><option value="0">Нет доступного времени. Пожалуйста, выберите другой день.</option></div>
                        </#list>
                    </select>
                </label>
            </div>
            <div class="vvod">
                <label>
                    Введите номер полиса пациента:
                    <input type="text" name="patient_app_ad" list="users" placeholder="№ полиса"/>
                    <datalist id="users">
                        <#list users>
                            <#items as patient_app_ad>
                                <div class="vvod"><option value="${patient_app_ad.id}">${patient_app_ad.policy_number}</option></div>
                            </#items>
                        </#list>
                    </datalist>
                </label>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit">Записаться</button>
        </form>

        <a href="#" onclick="history.back();return false;">Вернуться назад</a>
    </div>

</@c.page>