local widget =  require ("widget") -- para os botoes
local composer = require ("composer") -- para as telas
local scene = composer.newScene()

-----------------------conectar ao banco de dados ------------------------
local sqlite3 = require( "sqlite3" )
 
local path = system.pathForFile( "data.db", system.DocumentsDirectory )
local db = sqlite3.open( path )
--------------------------------------------------------------------------

local LabelUser
local LabelPassword
local TxtUserName
local TxtPassword
local Buttonlogin
local ButtonSingIn
local storeID -- armazenar id


function scene:create(event)
	
	local grupoCena = self.view 	

	LabelUser = display.newText({text="UserName",x=display.contentWidth/2,y=display.contentHeight/2 - 23})
	LabelUser:setFillColor(0,1,0)
	grupoCena:insert(LabelUser)

	LabelPassword = display.newText({text="Password",x=display.contentWidth/2,y=display.contentHeight/2 + 25})
	LabelPassword:setFillColor(0,1,0)

	grupoCena:insert(LabelPassword)

	Buttonlogin = widget.newButton( {label="Login", x = display.contentWidth/2 -50, y = display.contentHeight/2 + 80, onPress = touchOnButtonLogin} )
	grupoCena:insert(Buttonlogin)

	ButtonSingIn = widget.newButton( {label="Cadastre-se", x = display.contentWidth/2 + 30, y = display.contentHeight/2 + 80, onPress = registrarUsuario} )
	grupoCena:insert(ButtonSingIn)
end

function StoreID(id)
	return id
end

function touchOnButtonLogin(event) -- toque no botao de login

	if event.phase == "began" then
		for row in db:nrows("SELECT * FROM usuario") do
    	print( "Row id " .. row.id )

    		if row.nome == TxtUserName.text or row.email == TxtUserName.text then
    			if row.senha == TxtPassword.text then
    				--print( "Row id " .. row.id )
    			StoreID(row.id)
    			composer.gotoScene("Logado")
    			end
    		end
    	end    	
	end
end

function  registrarUsuario(event) -- toque no botao sing in 
	-- vai para a pagina de cadastro
	if event.phase == "began" then
		composer.gotoScene("CadastrarUsuario")
	end

end

function scene:show(event) 

	if event.phase == "did" then
		TxtUserName = native.newTextField(display.contentWidth/2, display.contentHeight/2, 150, 25 )
		TxtUserName.isEditable = true
		TxtUserName.size = 14
		TxtPassword = native.newTextField(display.contentWidth/2, display.contentHeight/2 + 50, 150, 25 )
		TxtPassword.isSecure = true
		TxtPassword.isEditable = true
		TxtPassword.size = 14
	end
end

function scene:hide(event)
	if event.phase == "will" then
		TxtUserName:removeSelf() 
		TxtPassword:removeSelf()
	end	
end

function scene:destroy(event)
end

scene:addEventListener( "create", scene ) -- adiciona o evento da funcao de criar 
scene:addEventListener( "show", scene ) -- adiciona o evento da funcao de entre 
scene:addEventListener( "hide", scene ) -- adiciona o evento da funcao de sair
scene:addEventListener( "destroy", scene )-- adiciona o evento da funcao de destruir 

return scene











--[[
local email = "username@domain.com"
 
if ( email:match("[A-Za-z0-9%.%%%+%-]+@[A-Za-z0-9%.%%%+%-]+%.%w%w%w?%w?") ) then
   print( email.." IS formatted properly." )
else
   print( email.." is NOT formatted properly." )
end
]]---
