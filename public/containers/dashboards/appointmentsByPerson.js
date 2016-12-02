import React, { Component } from 'react'
import { connect } from 'react-redux'
import { Link } from 'react-router'
import { AreaChart, Area, XAxis, YAxis, ZAxis, Tooltip, CartesianGrid, Brush, Legend,
  ReferenceArea, ReferenceLine, ReferenceDot,
  ResponsiveContainer, ComposedChart, Bar, Line,
  LineChart } from 'recharts';

export default class AppointmentsByPerson extends Component {
  render() {
    return (
      <LineChart width={730} height={250} data={weekAppointments}
        margin={{ top: 5, right: 30, left: 20, bottom: 5 }}>
        <XAxis dataKey="name" />
        <YAxis />
        <CartesianGrid strokeDasharray="3 3" />
        <Tooltip />
        <Legend />
        <Line type="monotone" dataKey="joaquim" name="Joaquim" stroke="#8884d8" />
        <Line type="monotone" dataKey="maria" name="Maria" stroke="#82ca9d" />
        <Line type="monotone" dataKey="matheus" name="Matheus" stroke="#3273dc" />
      </LineChart>
    );
  }
}
const weekAppointments = [
    { name: 'Segunda', joaquim: 7, maria: 1, matheus: 3 },
    { name: 'Terça', joaquim: 4, maria: 2, matheus: 11 },
    { name: 'Quarta', joaquim: 2, maria: 5, matheus: 3 },
    { name: 'Quinta', joaquim: 1, maria: 4, matheus: 2 },
    { name: 'Sexta', joaquim: 1, maria: 0, matheus: 6 },
    { name: 'Sábado', joaquim: 0, maria: 2, matheus: 8 },
    { name: 'Domingo', joaquim: 3, maria: 1, matheus: 6 },
];
