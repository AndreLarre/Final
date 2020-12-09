var ProjetoController = new function() {

    this.list = function() {
        $('#projetoTableBody').empty();

        $.get( "/projetos", function( data ) {
            $.each(data, function(_i, item) {
                $('<tr>').append(
                    $('<td>').text(item.idProjeto),
                    $('<td>').text(item.nome),
                    $('<td>').text(item.Empresa),
                    $('<td>').text(item.Senha),
                    $('<td class="actions"><a class="btn btn-warning btn-xs" onclick="ProjetoController.edit('+item.idProjeto+')">Editar</a><a class="btn btn-danger btn-xs" onclick="ProjetoController.delete('+item.idProjeto+')">Excluir</a></td>')
                ).appendTo('#projetoTableBody');
            });
        });
    }

    this.projetoList = function() {
        $('#projetoSelectList').empty();
        $.get( "/projetos", function( data ) {
            $.each(data, function(i, item) {
                $('<option value='+item.idProjeto+'>'+item.nome+'</option>').appendTo('#projetoSelectList');
            });
        });
    }

    this.delete = function(idProjeto) {
        $.ajax({
            url: '/projetos/'+idProjeto,
            method: 'DELETE',
            contentType: 'application/json',
            success: function(result) {
                ProjetoController.list();
            },
            error: function(request,msg,error) {
                alert('erro ao deletar');
            }
        });
    }

    this.save = function() {
        var idProjetoToEdit = $("#projetoId").val();

        if (idrojetoToEdit == null || idProjetoToEdit == "") {
            var projeto = this.getDadosProjetoModal();

            $.ajax({
                url: '/projeto',
                type: 'POST',
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                data: JSON.stringify(projeto),
                success: function() {
                    $("#projetoId").val("");
                    $('#cadastrarprojeto').modal('hide');
                    ProjetoController.list();
                    ProjetoController.limparDadosProjetoModal();
                },
                error: function(request,msg,error) {
                    $("#projetoId").val("");
                    $('#cadastrarProjeto').modal('hide');
                    ProjetoController.list();
                    ProjetoController.limparDadosProjetoModal();
                }
            });
        }
        else {
            ProjetoController.update(idProjetoToEdit);
        }

    }

    this.update = function(idProjeto) {
        var projeto = this.getDadosProjetoModal();

        $.ajax({
            url: '/projetos/'+idProjeto,
            method: 'PUT',
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            data: JSON.stringify(projeto),
            success: function(result) {
                $("#projetoId").val("");
                $('#cadastrarProjeto').modal('hide');
                ProjetoController.list();
                ProjetoController.limparDadosProjetoModal();
            },
            error: function(request,msg,error) {
                $("#projetoId").val("");
                $('#cadastrarProjeto').modal('hide');
                ProjetoController.list();
                ProjetoController.limparDadosProjetoModal();
            }
        });
    }

    this.edit = function(idProjeto) {
        $("#projetoId").val(idProjeto);

        $.get( "/projetos/" + idProjeto, function( data ) {
            $('#cadastrarProjeto').modal('show');
            ProjetoController.setDadosProjetoModal(data);
        });
    }

    this.setDadosProjetoModal = function(projeto) {
        $('#projetoNome').val(projeto.nome),
            $('#projetoEmpresa').val(projeto.Empresa),
            $('#projetoSenha').val(medico.Senha)
    }

    this.limparDadosProjetoModal = function() {
        $('#projetoNome').val(''),
            $('#projetoEmpresa').val(''),
            $('#projetoSenha').val('')
    }

    this.getDadosProjetoModal = function() {
        var projeto = {
            nome: $('#projetoNome').val(),
            Empresa: $('#projetoEmpresa').val(),
            Senha: $('#projetoSenha').val(),
        }

        return projeto;
    }

}
