--Code here
--ListarUsuarios

local widget =  require ("widget") -- para os botoes
local composer = require ("composer") -- para as telas
local scene = composer.newScene()
--local perfil = require("Perfil")

-----------------------conectar ao banco de dados ------------------------
local sqlite3 = require( "sqlite3" )
 
local path = system.pathForFile( "data.db", system.DocumentsDirectory )
local db = sqlite3.open( path )
--------------------------------------------------------------------------

function CriarBancoDeDados(event)
	local tablesetup = [[CREATE TABLE IF NOT EXISTS usuario (id INTEGER PRIMARY KEY autoincrement, nome, email, telefone, senha);]]
	variavel = db:exec( tablesetup )
	print("criacao do banco : " .. variavel)
end

CriarBancoDeDados()

local usuarios = {}

local ButtomVisualize
--Tentei, mas não foi eficaz! 
--[[
local saida
local sql = "SELECT * FROM usuario"
local cont = 0
for row in db:nrows(sql) do
	print(row.nome .. " " .. row.email .. " ")
	local armazenado = row.nome .. " " .. row.email .. " "
	local t = display.newText(armazenado, 20, 100 + (20 + cont), native.systemFont, 14)
	t:setTextColor( 1, 1, 1 )
end	
]]--

ButtomVisualize = widget.newButton( {label = "Listar Todos", x = display.contentWidth/2 -50, y = display.contentHeight/2 + 30 } )
    

function scene:create(event)
	local grupoCena = self.view 

    local texto = display.newText( {text = "Welcome!", x = display.contentWidth/2, y = display.contentHeight/2 , 150, 20, native.systemFont, 20})
    grupoCena:insert( texto )

    
    grupoCena:insert(ButtomVisualize)
    ButtomVisualize:addEventListener("touch",bucarUsuarios)
    
	--grupoCena:insert(t)

end

-- Analizem, se vcsconseguem mostrar as informações do usuário na tela! 
function bucarUsuarios(event)
	
local saida
local sql = "SELECT * FROM usuario"
local cont = 0
for row in db:nrows(sql) do
    --Console
    print(row.nome .. " " .. row.email .. " ")
    
    --Caso 1 
    local armazenado =row.nome .. " " .. row.email .. " "
    
    --Caso 2
    usuarios[#usuarios+1] = 
    {
     nome = row.nome,
     email = row.email,
     telefone = row.telefone,
     senha = row.senha
    }

    --Caso 1
    local t0 = display.newText(armazenado, 100, 100 + (20 + cont), native.systemFont, 14)
    --Caso 2
    local t = display.newText(#usuarios, 100, 100, 100, 100, native.systemFont, 14)
    t:setTextColor( 1, 1, 1 )


--bucarUsuarios()
  end
end

function scene:show( event )
 
   -- local sceneGroup = self.view
    local phase = event.phase
 
    if ( phase == "did" ) then
        -- Code here runs when the scene is entirely on screen
    
			 			
    end
end
 
 

function scene:hide( event )
 
   -- local sceneGroup = self.view
    local phase = event.phase
 
    if ( phase == "will" ) then
        -- Code here runs when the scene is on screen (but is about to go off screen)
       -- object:removeSelf( )
        
 
    end
end
 
 
-- destroy()
function scene:destroy( event )
 
    --local sceneGroup = self.view
    -- Code here runs prior to the removal of scene's view
 
end




scene:addEventListener( "create", scene )
scene:addEventListener( "show", scene )
scene:addEventListener( "hide", scene )
scene:addEventListener( "destroy", scene )

return scene