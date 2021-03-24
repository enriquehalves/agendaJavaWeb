<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Agenda Contatos</title>
<link rel="icon" href="imagens/fone.png">
<link rel="stylesheet" href="style.css">

</head>
<body>
	<h1>editar contato</h1>
	<form action="update" name="frmContato">
		<table>
			<tr>
				<td><input type="text" name="idcon" class="caixa1" id="caixa3" readonly="" value="<%out.print(request.getAttribute("idcon"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="nome" class="caixa1" value="<%out.print(request.getAttribute("nome"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="fone" class="caixa2" value="<%out.print(request.getAttribute("fone"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="email" class="caixa1" value="<%out.print(request.getAttribute("email"));%>"></td>
			</tr>
		</table>
		<input type="button" class="botao1" value="salvar" onclick="validar()">
	</form>
	<script src="scripts/validador.js">
		
	</script>
</body>
</html>