export default function(values) {
  let error = {}

  if(!values.name)
    error.name = 'Informe a descrição da Especie!'

  return error;
}
