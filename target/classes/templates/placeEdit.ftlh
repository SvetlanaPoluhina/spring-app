<#import "parts/common.ftlh" as c>

<@c.page>
    <div class="login">

        <form method="post">
            <div>
                <p>Изменение адреса:</p>
                <div class="vvod"><label><input type="address" name="address" value="${place!''}" /></label></div>
            </div>

            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit">Сохранить</button>
        </form>
    </div>
</@c.page>