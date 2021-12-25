<#import "parts/common.ftlh" as p>
<@p.page>
    <div class="fs-3 mb-3" style="">Edit user ${user.username}:</div>
    <div class="form-row">
        <div class="form-group col-sm-3">
            <form action="/users" method="post">
                <div class="mb-3">
                    <input type="text" class="form-control" name="userName" value="${user.username}">
                </div>
                <p class="fs-5">Access type:</p>
                <#list roles as role>
                    <div class="form-check">
                        <label><input type="checkbox" class="form-check-input" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
                    </div>
                </#list>
                <input type="hidden" value="${user.id}" name="userId">
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <div class="mt-3">
                    <button class="btn btn-primary" style="width:35%" type="submit">Save</button>
                </div>
            </form>
        </div>
    </div>
</@p.page>