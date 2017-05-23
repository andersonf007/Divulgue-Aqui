--rest
local widget =  require ("widget")
local composer = require ("composer")
local scene = composer.newScene()

-----------------------conectar ao banco de dados ------------------------
local sqlite3 = require( "sqlite3" )
 
local path = system.pathForFile( "data.db", system.DocumentsDirectory )
local db = sqlite3.open( path )
--------------------------------------------------------------------------
-- Vê se é necessário todos esses atributos, em especial o telefone!
local LabelNome
local LabelEmail
local LabelTelefone
local LabelSenha
local TxtNome
local TxtEmail
local TxtTelefone
local TxtSenha
local ButtonCadastrar 

function CriarBancoDeDados(event)
	local tablesetup = [[CREATE TABLE IF NOT EXISTS usuario (id INTEGER PRIMARY KEY autoincrement, nome, email, telefone, senha);]]
	variavel = db:exec( tablesetup )
	print("criacao do banco : " .. variavel)
end

CriarBancoDeDados()

function armazenarDados(nome, email, telefone, senha)
	local sql = [[INSERT INTO usuario VALUES (NULL, ']]..nome..[[',']]..email..[[',']]..telefone..[[',']]..senha..[[');]]
	db:exec( sql )
	print("mendagem do banco : " .. db:errmsg())
end

function scene:create(event)

	local grupoCena = self.view 
    
    local titulo = display.newText({text="Formulário",x=display.contentWidth/2 + 5,y=display.contentHeight/2 - 200})
    titulo:setFillColor( 1,1,0 )
    titulo.isEditable = true
    titulo.size = 30
    grupoCena:insert(titulo)

	LabelNome = display.newText({text="Nome",x=display.contentWidth/2 + 5,y=display.contentHeight/2 - 170})
	LabelNome:setFillColor(0,1,0)
	grupoCena:insert(LabelNome)
	

	LabelEmail = display.newText({text="Email",x=display.contentWidth/2 + 5,y=display.contentHeight/2 - 120})	
	LabelEmail:setFillColor(0,1,0)
	grupoCena:insert(LabelEmail)


	LabelTelefone = display.newText({text="Telefone",x=display.contentWidth/2 + 5,y=display.contentHeight/2 -70})	
	LabelTelefone:setFillColor(0,1,0)
	grupoCena:insert(LabelTelefone)


	LabelSenha = display.newText({text="Senha",x=display.contentWidth/2 + 5,y=display.contentHeight/2 - 20})
	LabelSenha:setFillColor(0,1,0)
	grupoCena:insert(LabelSenha)


	ButtonCadastrar =  widget.newButton( {label="Cadastrar", x = display.contentWidth/2, y = display.contentHeight/2 + 30 ,onPress = salvarUsuario} )
	grupoCena:insert(ButtonCadastrar)
end

function salvarUsuario(event)

	if event.phase == "began" then
		armazenarDados(TxtNome.text, TxtEmail.text, TxtTelefone.text, TxtSenha.text)
		TxtNome.text = ""
		TxtEmail.text = ""
		TxtTelefone.text = ""
		TxtSenha.text = ""
		composer.gotoScene("login")
	end

end

function scene:show(event)
	if event.phase == "did" then
		TxtNome = native.newTextField(display.contentWidth/2, display.contentHeight/2 - 150, 200, 25 ) 
		TxtEmail = native.newTextField(display.contentWidth/2, display.contentHeight/2 - 100, 200, 25 ) 
		TxtTelefone = native.newTextField(display.contentWidth/2, display.contentHeight/2 - 50, 200, 25 ) 
		TxtTelefone.inputType = "number"
		TxtSenha = native.newTextField(display.contentWidth/2, display.contentHeight/2, 200, 25 ) 
	    TxtNome.isEditable = true
	    TxtNome.size = 14
	    TxtEmail.isEditable = true
	    TxtEmail.size = 14
	    TxtSenha.isEditable = true
	    TxtSenha.size = 14
	end
end

function scene:hide(event)
	display.remove(TxtNome)
	display.remove(TxtEmail)
	display.remove(TxtEmail)
	display.remove(TxtTelefone)
	display.remove(TxtSenha)
end

function scene:destroy(event)
end

scene:addEventListener( "create", scene ) 
scene:addEventListener( "show", scene )  
scene:addEventListener( "hide", scene ) 
scene:addEventListener( "destroy", scene )

return scene


