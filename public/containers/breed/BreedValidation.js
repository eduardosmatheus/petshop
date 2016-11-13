export default function(values) {
  let error = {}

  if(!values.name)
    error.name = 'Informe a descrição da Raça!'

  return error;
}
