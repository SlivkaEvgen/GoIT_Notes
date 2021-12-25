<#macro editForm>
<div class="form-group mt-3">
    <form method="post" action="/note/create" name="editNote">
        <div class="mb-3">
            <label for="noteNameInput" class="form-label">Note name</label>
            <input type="text" class="form-control" name="name" id="noteNameInput" placeholder="Enter note's name" value="${(editNote.name)!''}">
        </div>
        <div class="mb-3">
            <label for="noteTextarea" class="form-label">Note text</label>
            <textarea class="form-control" name="message" id="noteTextArea" style="resize:none" rows="20" placeholder="Enter your note">${(editNote.message)!''}</textarea>
        </div>
        <input type="hidden" class="form-control" name="noteId" value="${(editNote.id)!''}">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <div class="d-flex-row">
          <div class="row mb-3 d-flex justify-content-start">
                <fieldset class="row mb-3 ">
                    <legend class="col-form-label col-sm-2 pt-0">Access Types</legend>
                    <div class="col-sm-2 ">
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="accessType" id="Private" value="PRIVATE"
                                   <#if editNote??><#if editNote.accessType=="PRIVATE">checked<#else></#if><#else>checked</#if>>
                            <label class="form-check-label" for="Private">
                                Private
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="accessType" id="Public" value="PUBLIC"
                                   <#if editNote??><#if editNote.accessType=="PUBLIC">checked<#else></#if><#else></#if>>
                            <label class="form-check-label" for="Public">
                                Public
                            </label>
                        </div>
                    </div>
                </fieldset>
            </div>
            <div class="d-flex justify-content-end">
                <button type="button" class="btn btn-outline-primary m-2" onclick="location.href='/note/list'">Cancel</button>
                <button type="submit" class="btn btn-primary m-2">Save note</button>
            </div>
        </div>
    </form>
</div>
</#macro>