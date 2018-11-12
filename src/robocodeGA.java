import org.jgap.*;
import org.jgap.impl.*;

import robocode.control.BattleSpecification;
import robocode.control.BattlefieldSpecification;
import robocode.control.RobocodeEngine;
import robocode.control.RobotSpecification;

/* 
 * Sam Ternent
 * RoboCodeGATemplate
 * Simple config for starting a project with RoboCode and JGAP
 */

@SuppressWarnings("serial")
public class robocodeGA extends FitnessFunction {
	
	
	//System.setProperty("java.home", "C:\\Program Files\\Java\\jdk1.8.0_181");
	
	// set amount of generations to evolve
	public static final int MAX_GENERATIONS = 50; // Isso pode ser mudado
	// set population size per generation
	public static final int POPULATION_SIZE = 50; // Isso pode ser mudado
	// amount of chromosomes
	public static final int CHROMOSOME_AMOUNT = 8; // Isso pode ser aumentado ou diminuido
												   // mas pra isso precisa adicionar ou remover manualmente
												   // na parte de declarar os sampleGenes no metodo run
	// track scores
	public static int robotScore,enemyScore;
	
	// number of rounds
	public static final int NUMBER_OF_ROUNDS = 3;

	public void run() throws Exception {

	    Configuration conf = new DefaultConfiguration(); // setup GA with default config
	    conf.addGeneticOperator(new MutationOperator(conf, 100)); // add new crossover opp 1/10% rate to the GA
	    conf.setPreservFittestIndividual(true); // use elitsim
	    conf.setFitnessFunction(this); // Set fitness function to conf
	    
	    //set up sample genes - add multiple genes to the array
	    Gene[] sampleGenes = new Gene[ CHROMOSOME_AMOUNT ];
	    sampleGenes[0] = new DoubleGene(conf, 300, 1000); // andar
		sampleGenes[1] = new DoubleGene(conf, 300, 700); // atirar
		sampleGenes[2] = new DoubleGene(conf, 300, 700); // virar tank direita
		sampleGenes[3] = new DoubleGene(conf, 300, 700); // virar tank esquerda
		sampleGenes[4] = new DoubleGene(conf, 300, 700); // virar radar direita
		sampleGenes[5] = new DoubleGene(conf, 300, 700); // virar radar esquerda
		sampleGenes[6] = new DoubleGene(conf, 300, 1000); // virar arma direita
		sampleGenes[7] = new DoubleGene(conf, 300, 1000); // virar arma esquerda

		IChromosome sampleChromosome = new Chromosome(conf, sampleGenes); // create chromo from genes
		conf.setSampleChromosome(sampleChromosome); // set chromo to conf
		
		conf.setPopulationSize(POPULATION_SIZE); // create a population
		
		//set random population
		Genotype population = Genotype.randomInitialGenotype(conf);
		IChromosome fittestSolution = null;
		
		//evolve population
		for ( int gen = 0; gen<MAX_GENERATIONS; gen++ ) {
			System.out.println("evolving");
			population.evolve(); // evolve population
			System.out.println("after evolve");
			fittestSolution = population.getFittestChromosome(); // find fittest of population
			System.out.printf("\nafter %d generations the best solution is %s \n",gen + 1,fittestSolution);	
		}  	

		buildRobot(fittestSolution); //pass best solution to build
		System.exit(0); // clean exit
	}
	
	public static void main(String[] args) throws Exception {
		new robocodeGA().run(); // run main
	}
	
	public boolean battleResults(String name,int score){
		String same = "custom.JoselitoBot*"; // enter robot name here with folder prefix
		
		//get results of battle
		if(name.equals(same)){
			robotScore = score;
			return true;
		}
		else {
			enemyScore = score;
			return false;
		}
	}
	
	private void buildRobot (IChromosome chromosome) {
		int i = 0;
		
		//break down chromosome to array
		double[ ] chromo = new double[ CHROMOSOME_AMOUNT ];
		for ( Gene gene : chromosome.getGenes() ) {
			chromo[i] += (Double) gene.getAllele(); // get value from gene
			i++;
		}
		createRobot.create(chromo);	 // create robot - func in createRobot.java
	}
	
	@Override
    protected double evaluate( IChromosome chromosome) {
    	int fitness,
    		numberOfRounds = NUMBER_OF_ROUNDS;
    	
    	buildRobot(chromosome); // build robot
	    
        RobocodeEngine engine = new RobocodeEngine(); // create robocode engine
        engine.addBattleListener(new battleObserver()); // add battle listener to engine
        engine.setVisible(false); // show battle in GUI ?
        
        BattlefieldSpecification battlefield = new BattlefieldSpecification(800, 600); // battle field size
        RobotSpecification[] selectedRobots = engine.getLocalRepository("sample.RamFire,sample.Walls,sample.Crazy,custom.JoselitoBot*"); // which sample bots to take to battle
        BattleSpecification battleSpec = new BattleSpecification(numberOfRounds, battlefield, selectedRobots);
        
        engine.runBattle(battleSpec, true); // run battle - wait till the battle is over
        engine.close(); // clean up engine
        
        fitness = robotScore; // set fitness score
        
        return fitness > 0 ? fitness : 0; // return fitness score if it's over 0
    }
    
    public void sortScore(int roboScore,int enemScore){
    	robotScore = roboScore;
    	enemyScore = enemScore;
    }
}
