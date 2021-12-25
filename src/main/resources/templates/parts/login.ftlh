<#macro login path isRegisterForm>
<form action="${path}" method="post" xmlns="http://www.w3.org/1999/html">
    <div class="form-group col-sm-4 mx-auto">
        <label for="inputUserName" class="col-sm-3 form-label"> User Name :</label>
        <input type="text" class="form-control" id="inputUserName" aria-describedby="userNameHelp" placeholder="Enter login" name="username"/>
        <#if isRegisterForm>
        <div id="userNameHelp" class="form-text">Use only english letters and numbers</div>
        </#if>
    </div>
    <div class="form-group col-sm-4 mx-auto mt-2">
        <label for="inputPassword" class="col-sm-2 form-label"> Password:</label>
        <input type="password" class="form-control" id="inputPassword" aria-describedby="passHelp" placeholder="Enter password" name="password"/>
        <#if isRegisterForm>
        <div id="passHelp" class="form-text">Length from 8 to 100 characters</div>
    </#if>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <div class="d-grid gap-2 col-2 mx-auto"><input type="submit" class="btn btn-primary mt-3" value="<#if isRegisterForm>Create<#else>Sign In</#if>"/></div>
    <div class="d-grid gap-2 col-2 mx-auto mt-3">
        <#if !isRegisterForm>
        <button type="button" class="btn btn-outline-primary" onclick="location.href='/register'">Registration</button>
    </#if>
    <#if isRegisterForm>
    <button type="button" class="btn btn-outline-primary" onclick="location.href='/login'">Login</button>
</#if>
    </div>
</form>
</#macro>

<#macro logout>
<form action="/logout" method="post" class="mx-2">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <input type="submit" class="btn btn-light" value="Sign Out"/>
</form>
</#macro>