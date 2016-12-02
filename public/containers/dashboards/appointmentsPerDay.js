import React, { Component } from 'react'
import { connect } from 'react-redux'
import { Link } from 'react-router'
import { AreaChart, Area, XAxis, YAxis, Tooltip,
  CartesianGrid, Brush, Legend,
  ReferenceArea, ReferenceLine, ReferenceDot,
  ResponsiveContainer, LineChart, Line,
  BarChart, Bar } from 'recharts';

export default class AppointmentsPerDay extends Component {
    render() {
      return(
        <BarChart width={600} height={300} data={data}>
          <XAxis dataKey="name" stroke="#000000" />
          <YAxis stroke="#000000"/>
          <Tooltip wrapperStyle={{ width: 150, backgroundColor: '#ffffff' }} />
          <Legend width={180} wrapperStyle={{ top: 40, right: 20, backgroundColor: '#f5f5f5', border: '1px solid #d5d5d5', borderRadius: 3, lineHeight: '40px' }} />
          <CartesianGrid stroke="#afa" strokeDasharray="5 5" />
          <Bar type="monotone" dataKey="atendimentos" fill="#3273dc" barSize={30} />
        </BarChart>
      );
    }
  }

//TO DO: Receber dados do reducer e do endpoint REST
const data = [
    { name: 'Segunda', atendimentos: 8, pv: 2400, amt: 2400, time: 1 },
    { name: 'Terça', atendimentos: 6, pv: 1398, amt: 2210, time: 3 },
    { name: 'Quarta', atendimentos: 7, pv: 9800, amt: 2290, time: 9 },
    { name: 'Quinta', atendimentos: 5, pv: 3908, amt: 2000, time: 10 },
    { name: 'Sexta', atendimentos: 1, pv: 4800, amt: 2181, time: 12 },
    { name: 'Sábado', atendimentos: 2, pv: 3800, amt: 2500, time: 16 },
    { name: 'Domingo', atendimentos: 4, pv: 4300, amt: 2100, time: 18 },
  ];
