<#macro errorlist>
<div class="alert alert-danger d-flex align-items-center" role="alert">
    <div class="mr-10">
    <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Danger:"><use xlink:href="#exclamation-triangle-fill"/></svg>
    </div>
    <div class="fs-4 pl-10" >
        <ul class="list-group list-unstyled">
            <#list message as msg>
            <li class="">${msg}</li>
            </#list>
        </ul>
    </div>
</div>
</#macro>

<#macro error>
<div class="alert alert-danger d-flex align-items-center" role="alert">
    <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Danger:"><use xlink:href="#exclamation-triangle-fill"/></svg>
    <div class="fs-4">
        ${message!""}
    </div>
</div>
</#macro>