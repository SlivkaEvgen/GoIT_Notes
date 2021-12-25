<#import "parts/common.ftlh" as p>
<@p.page>
<div class="form-row">
    <div class="form-group col-md-6">
        <form method="get" action="/main" class="form-inline">
            <input type="text" name="filter" value="${filter?ifExists}" placeholder="Search by name">
            <button type="submit" class="btn btn-primary ml-2">Search</button>
        </form>
    </div>
</div>
<a class="btn btn-primary mt-2" data-bs-toggle="collapse" href="#collapseNote" role="button" aria-expanded="false" aria-controls="collapseMote">
    Add new Note
</a>
<div class="collapse" id="collapseNote">
    <div class="form-group mt-3">
    <form method="post">
        <div class="form-group mt-3">
            <input type="text" name="text" class="form-control" placeholder="Input note"/>
        </div>
        <div class="form-group mt-3">
            <input type="text" name="tag" class="form-control" placeholder="Tag"/>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-primary mt-3">Add note</button>
    </form>
    </div>
</div>

</@p.page>